package top.ourck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ourck.beans.*;
import top.ourck.dao.*;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentBookService {

    @Autowired
    private AttendDAO aDao;

    @Autowired
    private UseBookDAO ubDao;

    @Autowired
    private BookDAO bDao;

    @Autowired
    private BookDetailDAO bdDao;

    @Autowired
    private StudentDAO sDao;

    @Autowired
    private StudentDetailDAO sdDao;

    @Autowired
    private BookOrderDAO boDao;

    @Autowired
    private UseBookService ubService;

    public List<UseBook> getUseBookByStudentId(int id)
    {
        Student stu = sDao.select(id);
        StudentDetail stud = stu.getStudentDetail();
        List<Attend> att = aDao.selectByCid(stud.getClazz().getId());
        List<UseBook> ub = new LinkedList<UseBook>();
        for(Attend attend : att) {
        	ub.addAll(ubService.getUseBookByLid(attend.getLesson().getId()));
        }
        return ub;
    }

    public void setBookOrderNum(BookOrder obj)
    {
        boDao.update(obj);
    }
}
