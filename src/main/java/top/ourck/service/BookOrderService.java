package top.ourck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Book;
import top.ourck.beans.BookOrder;
import top.ourck.beans.Student;
import top.ourck.dao.BookDAO;
import top.ourck.dao.BookOrderDAO;
import top.ourck.dao.StudentDAO;

@Service
public class BookOrderService {
	
	@Autowired
    private BookOrderDAO boDao;
    
    @Autowired
    private BookDAO bDao;
    
    @Autowired
    private StudentDAO sDao;

    public int getNumByIdAndBid(int uid ,int bid)
    {
        BookOrder bo = boDao.selectByUidBid(uid, bid);
        if(bo == null)
            return 1;
        else
            return bo.getNum();
    }
    
    public void updateBookNum(int uid, int bid, int num)
    {
    	Book bk = bDao.select(bid);
    	Student stu = sDao.select(uid);
    	BookOrder bo = boDao.selectByUidBid(uid, bid);
    	if(bo != null) {
    		bo.setBook(bk);
    		bo.setStudent(stu);
    		bo.setNum(num);
    		updateBookOrder(bo);
    	}
    	else {
    		bo = new BookOrder();
    		bo.setBook(bk);
    		bo.setStudent(stu);
    		bo.setNum(num);
    		addBookOrder(bo);
    	}
    }
    
    public List<BookOrder> list() {
    	return boDao.list(0, 1000);
    }
    
    public List<BookOrder> listByBid() {
    	return boDao.listGroupByBid(0, 1000);
    }
    
    public void addBookOrder(BookOrder bo) {
    	boDao.add(bo);
    }
    
    public void deleteBookOrder(int id) {
    	boDao.delete(id);
    }
    
    public void updateBookOrder(BookOrder bo) {
    	boDao.update(bo);
    }
    
    public BookOrder getById(int id) {
    	return boDao.select(id);
    }
}
