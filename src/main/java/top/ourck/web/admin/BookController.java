package top.ourck.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Book;
import top.ourck.beans.BookDetail;
import top.ourck.service.BookService;
import top.ourck.util.StringUtil;

@Controller
@RequestMapping("/admin/mgr/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = {""})
	public String index(Model model) {
		List<Book> tList = bookService.list();
		model.addAttribute("objList", tList);
		return "admin/mgr/book/bookMgr";
	}
	
	@RequestMapping("/edit/{bid}")
	public String edit(@PathVariable("bid") int bid, Model model) {
		Book b = bookService.getById(bid);
		model.addAttribute("obj", b);
		return "admin/mgr/book/bookEdit";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("status") String status,
						@RequestParam("name") String name,
						@RequestParam("ISBN") String isbn,
						@RequestParam("edition") String edition,
						@RequestParam("chief_editor") String chiefEditor,
						@RequestParam("institute") String institute,
						@RequestParam("pub_date") String pubDate,
						@RequestParam("author") String author,
						@RequestParam("price") String priceStr) {
		name = StringUtil.asNull(name);
		status = StringUtil.asNull(status);
		if(StringUtil.isNull(name) || StringUtil.isNull(status)) {
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
			b.setStatus(status);
			b.setBookDetail(bd);
			b.setBookDetail(bd);
			bookService.addBook(b);
		}
		
		return "redirect:/admin/mgr/book";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("id") Integer id,
						@RequestParam("detail_id") Integer detailId,
						@RequestParam("status") String status,
						@RequestParam("name") String name,
						@RequestParam("ISBN") String isbn,
						@RequestParam("edition") String edition,
						@RequestParam("chief_editor") String chiefEditor,
						@RequestParam("institute") String institute,
						@RequestParam("pub_date") String pubDate,
						@RequestParam("author") String author,
						@RequestParam("price") Float price) {
		name = StringUtil.asNull(name);
		status = StringUtil.asNull(status);
		if(StringUtil.isNull(name) || StringUtil.isNull(status)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			BookDetail bd = new BookDetail(); 
			bd.setId(detailId);
			bd.setName(StringUtil.asNull(name));
			bd.setISBN(StringUtil.asNull(isbn));
			bd.setEdition(StringUtil.asNull(edition));
			bd.setChiefEditor(StringUtil.asNull(chiefEditor));
			bd.setInstitute(StringUtil.asNull(institute));
			bd.setPubDate(StringUtil.asNull(pubDate));
			bd.setAuthor(StringUtil.asNull(author));
			bd.setPrice(price);
			
			Book b = new Book();
			b.setId(id);
			b.setStatus(status); // 上面已经校验过status有效性了
			b.setBookDetail(bd);
			b.setBookDetail(bd);
			bookService.updateBook(b);
		}
		
		return "redirect:/admin/mgr/book";
	}

	@RequestMapping("/delete/{bid}")
	public String delete(@PathVariable("bid") int bid) {
		bookService.deleteBook(bid);
		return "redirect:/admin/mgr/book";
	}
}
