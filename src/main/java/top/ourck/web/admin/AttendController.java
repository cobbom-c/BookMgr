package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Attend;
import top.ourck.service.AttendService;
import top.ourck.service.ClassService;
import top.ourck.service.LessonService;

@Controller
@RequestMapping("/admin/mgr/attend")
public class AttendController {

	private static final String HOME_PAGE = "/admin/mgr/attend";
	
	@Autowired
	private AttendService attendService;
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("objList", attendService.listAttend());
		return "admin/mgr/attend/attendMgr";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("cid") Integer cid,
						@RequestParam("lid") Integer lid) {
		Attend attend = new Attend();
		attend.setClazz(classService.getById(cid));
		attend.setLesson(lessonService.getById(lid));
		attendService.addAttend(attend);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		attendService.deleteAttend(id);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Attend m = attendService.getAttendById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/attend/attendEdit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Integer id,
						@RequestParam("cid") Integer cid,
						@RequestParam("lid") Integer lid) {
		Attend attend = new Attend();
		attend.setId(id);
		attend.setClazz(classService.getById(cid));
		attend.setLesson(lessonService.getById(lid));
		attendService.updateAttend(attend);
		return "redirect:" + HOME_PAGE;
	}
}
