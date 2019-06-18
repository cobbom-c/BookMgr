package top.ourck.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import top.ourck.beans.Teacher;
import top.ourck.beans.util.UserHolder;
import top.ourck.service.TeacherService;

@Controller
@RequestMapping("/tch")
public class TeacherController {

	@Autowired
	private TeacherService tchService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "tch/index";
	}
	
	@RequestMapping("/bookmgr")
	public String bookMgr(Model model) {
		return "tch/bookMgr";
	}
}
