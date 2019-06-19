package top.ourck.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import top.ourck.service.StudentService;


@Controller
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = {"/", "", "/index"})
	public String index() {
		return "stu/index";
	}
	
	@RequestMapping("/logout")
	public String logout(@CookieValue("ticket") String ticket) {
		studentService.logout(ticket);
		return "redirect:/login/auth";
	}
	
	@RequestMapping("/bookorder")
	public String bookMgr(Model model) {
		return "stu/bookOrder";
	}
}
