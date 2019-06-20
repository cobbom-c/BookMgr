package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Major;
import top.ourck.beans.Class;
import top.ourck.dao.ClassDAO;
import top.ourck.dao.MajorDAO;

@Service
public class ClassAndMajorService {

	@Autowired
	private MajorDAO majorDAO;
	
	@Autowired
	private ClassDAO classDAO;
	
	// Major CRUD
	
	public List<Major> listMajor() {
		return majorDAO.list(0, 1000);
	}
	
	public void addMajor(Major major) {
		majorDAO.add(major);
	}
	
	public void updateMajor(Major major) {
		majorDAO.update(major);
	}
	
	public Major getMajorById(int id) {
		return majorDAO.select(id);
	}

	public void deleteMajor(int id) {
		majorDAO.delete(id);
	}
	
	// Class CRUD
	
	public List<Class> listClass() {
		return classDAO.list(0, 1000);
	}
	
	public void addClass(Class clazz) {
		classDAO.add(clazz);
	}
	
	public void updateClass(Class clazz) {
		classDAO.update(clazz);
	}
	
	public Class getClassById(int id) {
		return classDAO.select(id);
	}

	public void deleteClass(int id) {
		classDAO.delete(id);
	}
}
