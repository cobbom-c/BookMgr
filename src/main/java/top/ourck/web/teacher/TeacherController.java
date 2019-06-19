package top.ourck.web.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import top.ourck.service.TeacherService;


@Controller
@RequestMapping("/tch")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
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
		return "tch/bookMgr";
	}
}
