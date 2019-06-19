package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Major;
import top.ourck.service.ClassAndMajorService;

@Controller
@RequestMapping("/admin/mgr/major")
public class MajorController {

	@Autowired
	private ClassAndMajorService cmService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("objList", cmService.listMajor());
		return "admin/mgr/major/majorMgr";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("name") String name) {
		Major major = new Major();
		major.setName(name);
		cmService.addMajor(major);
		return "redirect:/admin/mgr/major";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		cmService.deleteMajor(id);
		return "redirect:/admin/mgr/major";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Major m = cmService.getMajorById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/major/majorEdit";
	}
	
	@RequestMapping("/update")
	public String uodate(@RequestParam("id") int id,
							@RequestParam("name") String name) {
		Major major = cmService.getMajorById(id);
		major.setName(name);
		cmService.updateMajor(major);
		return "redirect:/admin/mgr/major";
	}
}
