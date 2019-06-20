package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Attend;
import top.ourck.dao.AttendDAO;

@Service
public class AttendService {

	@Autowired
	private AttendDAO aDao;
	
	public List<Attend> listAttend() {
		return aDao.list(0, 1000);
	}
	
	public void addAttend(Attend attend) {
		aDao.add(attend);
	}
	
	public void updateAttend(Attend attend) {
		aDao.update(attend);
	}
	
	public Attend getAttendById(int id) {
		return aDao.select(id);
	}

	public void deleteAttend(int id) {
		aDao.delete(id);
	}
	
}
