package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.ourck.beans.Lesson;
import top.ourck.beans.LessonDetail;
import top.ourck.service.LessonService;
import top.ourck.util.StringUtil;

@Controller
@RequestMapping("/admin/mgr/lesson")
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("objList", lessonService.listLesson());
		return "admin/mgr/lesson/lessonMgr";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("name") String name,
						@RequestParam("lesson_code") String lessonCode,
						@RequestParam("type") String type,
						@RequestParam("education") String education,
						@RequestParam("pos") String pos,
						@RequestParam("language") String language,
						@RequestParam(value = "max_stunum", required = false) Integer maxStunum,
						@RequestParam(value = "stunum", required = false) Integer stunum,
						@RequestParam("begin_week") Integer beginWeek,
						@RequestParam("end_week") Integer endWeek,
						@RequestParam("total_week") Integer totalWeek,
						@RequestParam("practice_week") Integer practiceWeek,
						@RequestParam("hours_weekly") Integer hoursWeekly,
						@RequestParam("total_hours") Integer totalHours,
						@RequestParam("score") Integer score,
						@RequestParam("semaster") Integer semaster) {
		LessonDetail ld = new LessonDetail(null,
									StringUtil.asNull(lessonCode),
									StringUtil.asNull(type),
									StringUtil.asNull(education),
									StringUtil.asNull(pos),
									StringUtil.asNull(language),
									maxStunum,
									stunum,
									beginWeek,
									endWeek,
									totalWeek,
									hoursWeekly,
									practiceWeek,
									totalHours,
									score,
									semaster);
		Lesson lesson = new Lesson(null, StringUtil.asNull(name), ld);
		lessonService.addLesson(lesson);
		return "redirect:/admin/mgr/lesson";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		lessonService.deleteLesson(id);
		return "redirect:/admin/mgr/lesson";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Lesson m = lessonService.getById(id);
		model.addAttribute("obj", m);
		return "admin/mgr/lesson/lessonEdit";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Integer id,
						@RequestParam("detail_id") Integer detailId,
						@RequestParam("name") String name,
						@RequestParam("lesson_code") String lessonCode,
						@RequestParam("type") String type,
						@RequestParam("education") String education,
						@RequestParam("pos") String pos,
						@RequestParam("language") String language,
						@RequestParam(value = "max_stunum", required = false) Integer maxStunum,
						@RequestParam(value = "stunum", required = false) Integer stunum,
						@RequestParam("begin_week") Integer beginWeek,
						@RequestParam("end_week") Integer endWeek,
						@RequestParam("total_week") Integer totalWeek,
						@RequestParam("practice_week") Integer practiceWeek,
						@RequestParam("hours_weekly") Integer hoursWeekly,
						@RequestParam("total_hours") Integer totalHours,
						@RequestParam("score") Integer score,
						@RequestParam("semaster") Integer semaster) {
		LessonDetail ld = new LessonDetail(detailId,
										StringUtil.asNull(lessonCode),
										StringUtil.asNull(type),
										StringUtil.asNull(education),
										StringUtil.asNull(pos),
										StringUtil.asNull(language),
										maxStunum,
										stunum,
										beginWeek,
										endWeek,
										totalWeek,
										hoursWeekly,
										practiceWeek,
										totalHours,
										score,
										semaster);
		Lesson lesson = new Lesson(id, StringUtil.asNull(name), ld);
		lessonService.updateLesson(lesson);
		return "redirect:/admin/mgr/lesson";
	}
}
