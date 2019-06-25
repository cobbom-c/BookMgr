package top.ourck.web.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Book;
import top.ourck.beans.BookDetail;
import top.ourck.beans.Lesson;
import top.ourck.beans.UseBook;
import top.ourck.beans.UserType;
import top.ourck.beans.util.User;
import top.ourck.beans.util.UserHolder;
import top.ourck.service.BookService;
import top.ourck.service.LessonService;
import top.ourck.service.TeacherService;
import top.ourck.service.UseBookService;
import top.ourck.util.StringUtil;


@Controller
@RequestMapping("/tch")
public class TeacherController {

	private static final String WAITING_TOBE_VERIFIED_STATUS = "待审核";
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private UseBookService ubService;
	
	@Autowired
	private UserHolder userHolder;
	
	@RequestMapping(value = {"", "/index", "/"})
	public String index(Model model) {
		return "tch/index";
	}
	
	@RequestMapping("/logout")
	public String logout(@CookieValue("ticket") String ticket) {
		teacherService.logout(ticket);
		return "redirect:/login/auth";
	}
	
	@RequestMapping("/bookmgr")
	public String bookMgr(Model model) {
		User user = userHolder.getUser();
		if(user != null && user.getType() == UserType.TEACHER) {
			model.addAttribute("objList", ubService.listByTid(user.getId()));
			return "tch/bookMgr";
		}
		else {
			// Login again!
			return "redirect:/login/auth";
		}
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("lid") Integer lid,
						@RequestParam("name") String name,
						@RequestParam("ISBN") String isbn,
						@RequestParam("edition") String edition,
						@RequestParam("chief_editor") String chiefEditor,
						@RequestParam("publisher") String institute,
						@RequestParam("pub_date") String pubDate,
						@RequestParam("author") String author,
						@RequestParam("price") String priceStr) {
		name = StringUtil.asNull(name);
		if(StringUtil.isNull(name)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			BookDetail bd = new BookDetail(); 
			bd.setName(StringUtil.asNull(name));
			bd.setISBN(StringUtil.asNull(isbn));
			bd.setEdition(StringUtil.asNull(edition));
			bd.setChiefEditor(StringUtil.asNull(chiefEditor));
			bd.setInstitute(StringUtil.asNull(institute));
			bd.setPubDate(StringUtil.asNull(pubDate));
			bd.setAuthor(StringUtil.asNull(author));
			Float price = (StringUtil.asNull(priceStr) == null ? Float.valueOf((float)0.0)
																: Float.parseFloat(priceStr));
			bd.setPrice(price);
			Book b = new Book();
			b.setStatus(WAITING_TOBE_VERIFIED_STATUS);
			b.setBookDetail(bd);
			bookService.addBook(b);
			
			Lesson l = lessonService.getById(lid);
			UseBook ub = new UseBook(null, l, b);
			ubService.addUseBook(ub);
		}
		
		return "redirect:tch/bookmgr";
	}
	
	
	@PostMapping("/update")
	public String update(@RequestParam("usebook_id") Integer ubId,
						@RequestParam("name") String name,
						@RequestParam("ISBN") String isbn,
						@RequestParam("edition") String edition,
						@RequestParam("chief_editor") String chiefEditor,
						@RequestParam("institute") String institute,
						@RequestParam("pub_date") String pubDate,
						@RequestParam("author") String author,
						@RequestParam("price") String priceStr) {
		name = StringUtil.asNull(name);
		if(StringUtil.isNull(name)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			UseBook ub = ubService.getUseBookById(ubId);
			Book b = ub.getBook();
			
			BookDetail bd = b.getBookDetail(); 
			bd.setName(StringUtil.asNull(name));
			bd.setISBN(StringUtil.asNull(isbn));
			bd.setEdition(StringUtil.asNull(edition));
			bd.setChiefEditor(StringUtil.asNull(chiefEditor));
			bd.setInstitute(StringUtil.asNull(institute));
			bd.setPubDate(StringUtil.asNull(pubDate));
			bd.setAuthor(StringUtil.asNull(author));
			Float price = (StringUtil.asNull(priceStr) == null ? Float.valueOf((float)0.0)
																: Float.parseFloat(priceStr));
			bd.setPrice(price);
			b.setStatus(WAITING_TOBE_VERIFIED_STATUS);
			b.setBookDetail(bd);
			bookService.updateBook(b);
			
			ub.setBook(b);
			ubService.updateUseBook(ub); // HINT 实际上这句没必要...改动的只是UseBook的Book而已，表里面的外键没改变
		}
		
		return "redirect:/tch/bookmgr";
	}
	
	@RequestMapping("/edit/{ubid}")
	public String edit(@PathVariable("ubid") int ubid, Model model) {
		UseBook ub = ubService.getUseBookById(ubid);
		model.addAttribute("obj", ub);
		return "tch/bookEdit";
	}
}
