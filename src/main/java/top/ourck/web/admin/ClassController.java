package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import top.ourck.service.ClassAndMajorService;

@Controller
@RequestMapping("/admin/mgr/class")
public class ClassController {

	@Autowired
	private ClassAndMajorService cmService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("objList", cmService.listClass());
		return "admin/mgr/class/classMgr";
	}
}
