package top.ourck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ourck.beans.UseBook;
import top.ourck.dao.UseBookDAO;

import java.util.List;

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

	public UseBook getUseBookByLid(int lid){return uDao.selectByLid(lid);}

	public void deleteUseBook(int id) {
		uDao.delete(id);
	}
	
}
