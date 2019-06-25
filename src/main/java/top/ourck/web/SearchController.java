package top.ourck.web;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.ourck.beans.Lesson;
import top.ourck.beans.UseBook;
import top.ourck.dao.LessonDAO;
import top.ourck.dao.UseBookDAO;

/**
 * TODO 访问这个API需要登陆？
 * @author ourck
 *
 */
@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private LessonDAO lDao;
	
	@Autowired
	private UseBookDAO ubDao;
	
	@RequestMapping(value = "/lesson", produces = {"application/json"})
	public String lessonSearch(@RequestParam("keyword") String keyword) {
		List<Lesson> list = lDao.search(keyword);
		JSONArray jary = new JSONArray();
		for(Lesson l : list) {
			JSONObject jobj = new JSONObject();
			jobj.put("id", l.getId());
			jobj.put("name", l.getName());
			jobj.put("code", l.getLessonDetail().getLessonCode());
			jobj.put("hours", l.getLessonDetail().getTotalHours());	
			jobj.put("semaster", l.getLessonDetail().getSemaster());
			jary.put(jobj);
		}
		
		return jary.toString();
	}
	
	@RequestMapping(value = "/usebook", produces = {"application/json"})
	public String usebookSearch(@RequestParam("lid") Integer lid) {
		List<UseBook> list = ubDao.listByLid(lid);
		JSONArray jary = new JSONArray();
		for(UseBook ub : list) {
			JSONObject jobj = new JSONObject();
			jobj.put("id", ub.getBook().getId());
			jobj.put("name", ub.getBook().getBookDetail().getName());
			jobj.put("isbn", ub.getBook().getBookDetail().getISBN());
			jobj.put("edition", ub.getBook().getBookDetail().getEdition());
			jobj.put("chief_editor", ub.getBook().getBookDetail().getChiefEditor());
			jobj.put("publisher", ub.getBook().getBookDetail().getInstitute());
			jobj.put("pub_date", ub.getBook().getBookDetail().getPubDate());
			jobj.put("author", ub.getBook().getBookDetail().getAuthor());
			jobj.put("price", ub.getBook().getBookDetail().getPrice());
			jary.put(jobj);
		}
		return jary.toString();
	}
}
