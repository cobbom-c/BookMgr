package top.ourck.service;

import top.ourck.beans.Class;
import top.ourck.dao.ClassDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

	@Autowired
	private ClassDAO cDao;
	
	public Class getById(int id) {
		return cDao.select(id);
	}
}
