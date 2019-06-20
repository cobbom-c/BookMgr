package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Instruct;
import top.ourck.service.InstructService;
import top.ourck.service.TeacherService;
import top.ourck.service.LessonService;

@Controller
@RequestMapping("/admin/mgr/instruct")
public class InstructController {

	private static final String HOME_PAGE = "/admin/mgr/instruct";
	
	@Autowired
	private InstructService instructService;
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private TeacherService classService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("objList", instructService.listInstruct());
		return "admin/mgr/instruct/instructMgr";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("tid") Integer tid,
						@RequestParam("lid") Integer lid) {
		Instruct instruct = new Instruct();
		instruct.setTeacher(classService.getById(tid));
		instruct.setLesson(lessonService.getById(lid));
		instructService.addInstruct(instruct);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		instructService.deleteInstruct(id);
		return "redirect:" + HOME_PAGE;
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Instruct m = instructService.getInstructById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/instruct/instructEdit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Integer id,
						@RequestParam("tid") Integer tid,
						@RequestParam("lid") Integer lid) {
		Instruct instruct = new Instruct();
		instruct.setId(id);
		instruct.setTeacher(classService.getById(tid));
		instruct.setLesson(lessonService.getById(lid));
		instructService.updateInstruct(instruct);
		return "redirect:" + HOME_PAGE;
	}
}
