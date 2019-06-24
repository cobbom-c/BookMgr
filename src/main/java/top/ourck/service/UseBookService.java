package top.ourck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Instruct;
import top.ourck.beans.UseBook;
import top.ourck.dao.UseBookDAO;

import java.util.LinkedList;
import java.util.List;

@Service
public class UseBookService {

	@Autowired
	private UseBookDAO uDao;
	
	@Autowired
	private InstructService instructService;
	
	public List<UseBook> listUseBook() {
		return uDao.list(0, 1000);
	}
	
	public void addUseBook(UseBook useBook) {
		uDao.add(useBook);
	}
	
	public void updateUseBook(UseBook useBook) {
		uDao.update(useBook);
	}
	
	public UseBook getUseBookById(int id) {
		return uDao.select(id);
	}

	public List<UseBook> getUseBookByLid(int lid) {
		return uDao.listByLid(lid);
	}

	public void deleteUseBook(int id) {
		uDao.delete(id);
	}
	
	/**
	 * 根据给定的教师用户ID，取得他录入的所有UseBook信息。
	 * @param tid 教师用户ID
	 * @return 所有UseBook信息
	 */
	public List<UseBook> listByTid(int tid) {
		List<UseBook> result = new LinkedList<UseBook>();
		List<Instruct> list = instructService.listInstructByTid(tid);
		for(Instruct ins : list) {
			result.addAll(getUseBookByLid(ins.getLesson().getId())); // result += each lesson by this teacher.
		}
		
		return result;
	}
}
