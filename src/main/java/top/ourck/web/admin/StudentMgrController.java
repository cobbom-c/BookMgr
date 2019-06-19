package top.ourck.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Class;
import top.ourck.beans.Student;
import top.ourck.beans.StudentDetail;
import top.ourck.service.ClassService;
import top.ourck.service.StudentService;
import top.ourck.util.StringUtil;

@Controller
@RequestMapping("/admin/mgr/student")
public class StudentMgrController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService ClassService;
	
	@RequestMapping(value = {""})
	public String index(Model model) {
		List<Student> tList = studentService.list();
		model.addAttribute("objList", tList);
		return "admin/mgr/stu/studentMgr";
	}
	
	@RequestMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") int tid, Model model) {
		Student t = studentService.getById(tid);
		model.addAttribute("obj", t);
		return "admin/mgr/stu/studentEdit";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("id") int tid,
						@RequestParam("detail_id") int detailId,
						@RequestParam("username") String userName,
						@RequestParam("password") String password,
						@RequestParam("name") String detailName,
						@RequestParam("hometown") String detailHomeTown,
						@RequestParam("cid") String detailCid) {
		userName = StringUtil.asNull(userName);
		password = StringUtil.asNull(password);
		if(StringUtil.isNull(userName) || StringUtil.isNull(password)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			StudentDetail td = new StudentDetail(); 
			td.setName(StringUtil.asNull(detailName));
			td.setHometown(StringUtil.asNull(detailHomeTown));
			Class clazz = ClassService.getById(Integer.parseInt(StringUtil.asNull(detailCid)));
			td.setClazz(clazz);
			if(detailId == -1) { // 如果这个人之前没有StudentDetail，先给他新建一个。
				studentService.addStudentDetail(td);
			}
			else {
				td.setId(detailId);
			}
			// 即使这三项留了空，也会真的在StudentDetail表中新建一条有id的、全null的记录
			
			Student t = new Student();
			t.setUserName(userName);
			t.setPassword(password);
			t.setStudentDetail(td);
			t.setId(tid);
			studentService.updateStudent(t);
		}
		
		return "redirect:/admin/mgr/student";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("username") String userName,
						@RequestParam("password") String password,
						@RequestParam("name") String detailName,
						@RequestParam("hometown") String detailHomeTown,
						@RequestParam("cid") String detailCid) {
		userName = StringUtil.asNull(userName);
		password = StringUtil.asNull(password);
		if(StringUtil.isNull(userName) || StringUtil.isNull(password)) {
			// TODO NULL IS NOT ALLOWED!
		}
		else {
			StudentDetail td = new StudentDetail(); 
			td.setName(StringUtil.asNull(detailName));
			td.setName(StringUtil.asNull(detailName));
			td.setHometown(StringUtil.asNull(detailHomeTown));
			if(StringUtil.asNull(detailCid) == null) {
				td.setClazz(null);
			}
			else {
				Class clazz = ClassService.getById(Integer.parseInt(detailCid));
				td.setClazz(clazz);
			}
			// 即使这三项留了空，也会真的在StudentDetail表中新建一条有id的、全null的记录
			
			Student t = new Student();
			t.setUserName(userName);
			t.setPassword(password);
			t.setStudentDetail(td);
			studentService.addStudent(t);
		}
		
		return "redirect:/admin/mgr/student";
	}
	
	@RequestMapping("/delete/{tid}")
	public String delete(@PathVariable("tid") int tid) {
		studentService.deleteStudent(tid);
		return "redirect:/admin/mgr/student";
	}
}
