package top.ourck.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.BookOrder;
import top.ourck.service.BookOrderService;
import top.ourck.service.BookService;
import top.ourck.service.StudentService;

@Controller
@RequestMapping("/admin/mgr/bookorder")
public class BookOrderController {

	private static final String HOME_PAGE = "/admin/mgr/bookorder";
	
	@Autowired
	private BookOrderService bookorderService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<BookOrder> ubList = bookorderService.list();
		model.addAttribute("objList", ubList);
		return "admin/mgr/bookorder/bookorderMgr";
	}
	
	@RequestMapping("/statics")
	public String statics(Model model) {
		// 这样取得的BookOrder，uid是空值。
		List<BookOrder> ubList = bookorderService.listByBid();
		model.addAttribute("objList", ubList);
		return "admin/mgr/bookorder/bookorderStatics";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("bid") Integer bid,
						@RequestParam("uid") Integer uid,
						@RequestParam("num") Integer num) {
		BookOrder bookorder = new BookOrder();
		bookorder.setBook(bookService.getById(bid));
		bookorder.setStudent(studentService.getById(uid));
		bookorder.setNum(num);
		bookorderService.addBookOrder(bookorder);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		bookorderService.deleteBookOrder(id);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		BookOrder m = bookorderService.getById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/bookorder/bookorderEdit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Integer id,
						@RequestParam("bid") Integer bid,
						@RequestParam("uid") Integer uid,
						@RequestParam("num") Integer num) {
		BookOrder bookorder = new BookOrder();
		bookorder.setId(id);
		bookorder.setBook(bookService.getById(bid));
		bookorder.setStudent(studentService.getById(uid));
		bookorder.setNum(num);
		bookorderService.updateBookOrder(bookorder);
		return "redirect:" + HOME_PAGE;
	}
}
