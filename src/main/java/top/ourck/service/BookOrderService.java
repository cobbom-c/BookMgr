package top.ourck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ourck.beans.BookOrder;
import top.ourck.dao.BookOrderDAO;

@Service
public class BookOrderService {
    @Autowired
    private BookOrderDAO boDao;

    public int getNumByIdAndBid(int uid ,int bid)
    {
        BookOrder bo = boDao.selectByUidBid(uid, bid);
        if(bo == null)
            return 1;
        else
            return bo.getNum();
    }
}
