package top.ourck.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.UseBook;
import top.ourck.service.UseBookService;
import top.ourck.service.BookService;
import top.ourck.service.LessonService;

@Controller
@RequestMapping("/admin/mgr/usebook")
public class UsebookController {

	private static final String HOME_PAGE = "/admin/mgr/usebook";
	
	@Autowired
	private UseBookService usebookService;
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<UseBook> ubList = usebookService.listUseBook();
		model.addAttribute("objList", ubList);
		return "admin/mgr/usebook/usebookMgr";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("bid") Integer bid,
						@RequestParam("lid") Integer lid) {
		UseBook usebook = new UseBook();
		usebook.setBook(bookService.getById(bid));
		usebook.setLesson(lessonService.getById(lid));
		usebookService.addUseBook(usebook);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		usebookService.deleteUseBook(id);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		UseBook m = usebookService.getUseBookById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/usebook/usebookEdit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Integer id,
						@RequestParam("bid") Integer bid,
						@RequestParam("lid") Integer lid) {
		UseBook usebook = new UseBook();
		usebook.setId(id);
		usebook.setBook(bookService.getById(bid));
		usebook.setLesson(lessonService.getById(lid));
		usebookService.updateUseBook(usebook);
		return "redirect:" + HOME_PAGE;
	}
}
