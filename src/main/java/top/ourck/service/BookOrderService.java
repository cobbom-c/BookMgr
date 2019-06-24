package top.ourck.service;

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
        BookOrder bo = boDao.select(uid, bid);
        if(bo == null)
            return 1;
        else
            return bo.getNum();
    }
    
    public void updateBookNum(int uid, int bid, int num)
    {
    	Book bk = bDao.select(bid);
    	Student stu = sDao.select(uid);
    	BookOrder bo = new BookOrder();
    	bo.setBook(bk);
    	if(boDao.select(uid, bid) != null)
    		boDao.update(bo);
    	else
    		boDao.add(bo);
    }
}
