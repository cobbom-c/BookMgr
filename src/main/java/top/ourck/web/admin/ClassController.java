package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Class;
import top.ourck.service.ClassAndMajorService;
import top.ourck.util.StringUtil;

@Controller
@RequestMapping("/admin/mgr/class")
public class ClassController {

	private static final String HOME_PAGE = "/admin/mgr/class";
	
	@Autowired
	private ClassAndMajorService cmService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("objList", cmService.listClass());
		return "admin/mgr/class/classMgr";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("name") String name,
						@RequestParam("grade") String gradeStr,
						@RequestParam("mid") int mid) {
		Class clazz = new Class();
		clazz.setName(StringUtil.asNull(name));
		clazz.setGrade(StringUtil.asNull(gradeStr));
		clazz.setMajor(cmService.getMajorById(mid));
		cmService.addClass(clazz);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		cmService.deleteClass(id);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Class m = cmService.getClassById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/class/classEdit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int id,
							@RequestParam("name") String name,
							@RequestParam("grade") String gradeStr,
							@RequestParam("mid") int mid) {
		Class clazz = cmService.getClassById(id);
		clazz.setName(StringUtil.asNull(name));
		clazz.setGrade(StringUtil.asNull(gradeStr));
		clazz.setMajor(cmService.getMajorById(mid));
		cmService.updateClass(clazz);
		return "redirect:" + HOME_PAGE;
	}
}
