package top.ourck.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Teacher;
import top.ourck.beans.TeacherDetail;
import top.ourck.service.TeacherService;
import top.ourck.util.StringUtil;

@Controller
@RequestMapping("/admin/mgr/teacher")
public class TeacherMgrController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = {""})
	public String index(Model model) {
		List<Teacher> tList = teacherService.list();
		model.addAttribute("objList", tList);
		return "admin/mgr/tch/teacherMgr";
	}
	
	@RequestMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") int tid, Model model) {
		Teacher t = teacherService.getById(tid);
		model.addAttribute("obj", t);
		return "admin/mgr/tch/teacherEdit";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("id") int tid,
						@RequestParam("detail_id") int detailId,
						@RequestParam("username") String userName,
						@RequestParam("password") String password,
						@RequestParam("name") String detailName,
						@RequestParam("phone") String detailPhone,
						@RequestParam("email") String detailEmail) {
		userName = StringUtil.asNull(userName);
		password = StringUtil.asNull(password);
		if(StringUtil.isNull(userName) || StringUtil.isNull(password)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			
			TeacherDetail td = new TeacherDetail(); 
			td.setName(StringUtil.asNull(detailName));
			td.setPhone(StringUtil.asNull(detailPhone));
			td.setEmail(StringUtil.asNull(detailEmail));
			if(detailId == -1) { // 如果这个人之前没有TeacherDetail，先给他新建一个。
				teacherService.addTeacherDetail(td);
			}
			else {
				td.setId(detailId);
			}
			// 即使这三项留了空，也会真的在TeacherDetail表中新建一条有id的、全null的记录
			
			Teacher t = new Teacher();
			t.setUserName(userName);
			t.setPassword(password);
			t.setTeacherDetail(td);
			t.setId(tid);
			teacherService.updateTeacher(t);
		}
		
		return "redirect:/admin/mgr/teacher";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("username") String userName,
						@RequestParam("password") String password,
						@RequestParam("name") String detailName,
						@RequestParam("phone") String detailPhone,
						@RequestParam("email") String detailEmail) {
		userName = StringUtil.asNull(userName);
		password = StringUtil.asNull(password);
		if(StringUtil.isNull(userName) || StringUtil.isNull(password)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			TeacherDetail td = new TeacherDetail(); 
			td.setName(StringUtil.asNull(detailName));
			td.setPhone(StringUtil.asNull(detailPhone));
			td.setEmail(StringUtil.asNull(detailEmail));
			// 即使这三项留了空，也会真的在TeacherDetail表中新建一条有id的、全null的记录
			
			Teacher t = new Teacher();
			t.setUserName(userName);
			t.setPassword(password);
			t.setTeacherDetail(td);
			teacherService.addTeacher(t);
		}
		
		return "redirect:/admin/mgr/teacher";
	}
	
	@RequestMapping("/delete/{tid}")
	public String delete(@PathVariable("tid") int tid) {
		teacherService.deleteTeacher(tid);
		return "redirect:/admin/mgr/teacher";
	}
}
