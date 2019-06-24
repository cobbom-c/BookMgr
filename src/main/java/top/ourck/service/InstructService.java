package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Instruct;
import top.ourck.dao.InstructDAO;

@Service
public class InstructService {

	@Autowired
	private InstructDAO iDao;
	
	public List<Instruct> listInstruct() {
		return iDao.list(0, 1000);
	}
	
	public List<Instruct> listInstructByTid(int tid) {
		return iDao.listByTid(tid, 0, 1000);
	}
	
	public void addInstruct(Instruct instruct) {
		iDao.add(instruct);
	}
	
	public void updateInstruct(Instruct instruct) {
		iDao.update(instruct);
	}
	
	public Instruct getInstructById(int id) {
		return iDao.select(id);
	}

	public void deleteInstruct(int id) {
		iDao.delete(id);
	}
	
}
