package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.UseBook;
import top.ourck.dao.UseBookDAO;

@Service
public class UseBookService {

	@Autowired
	private UseBookDAO uDao;
	
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

	public void deleteUseBook(int id) {
		uDao.delete(id);
	}
	
}
