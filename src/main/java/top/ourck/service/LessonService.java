package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Lesson;
import top.ourck.dao.LessonDAO;
import top.ourck.dao.LessonDetailDAO;

@Service
public class LessonService {
	
	@Autowired
	private LessonDAO lDao;
	
	@Autowired
	private LessonDetailDAO ldDao;
	
	// Lesson & LessonDetail CRUD
	
	public List<Lesson> listLesson() {
		return lDao.list(0, 1000);
	}
	
	public void addLesson(Lesson lesson) {
		ldDao.add(lesson.getLessonDetail());
		lDao.add(lesson);
	}
	
	public void updateLesson(Lesson lesson) {
		ldDao.update(lesson.getLessonDetail());
		lDao.update(lesson);
	}
	
	public Lesson getById(int id) {
		return lDao.select(id);
	}

	public void deleteLesson(int id) {
		Lesson l = getById(id);
		lDao.delete(l.getId());
		ldDao.delete(l.getLessonDetail().getId());
	}
	
}
