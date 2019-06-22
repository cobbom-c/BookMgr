package top.ourck.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import top.ourck.beans.Student;
import top.ourck.beans.UseBook;
import top.ourck.beans.UserType;
import top.ourck.beans.util.User;
import top.ourck.beans.util.UserHolder;
import top.ourck.service.BookOrderService;
import top.ourck.service.StudentBookService;
import top.ourck.service.StudentService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentBookOrderController {
    @Autowired
    private StudentBookService studentbookservice;

    @Autowired
    private UserHolder userholder;

    @Autowired
    private BookOrderService bookorderservice;

    @Autowired
    private StudentService studentservice;

    @GetMapping("/bookorder")
    public String showOrder(Model model)
    {
        List<Map<String, String>> bookinfo = new LinkedList<Map<String,String>>();
        User user = userholder.getUser();

        //处理学生信息
        Student stu = studentservice.getById(user.getId());
        model.addAttribute("academy", stu.getStudentDetail().getClazz().getMajor().getCollege());
        model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        model.addAttribute("name", stu.getStudentDetail().getName());
        model.addAttribute("id", user.getUserName());
        model.addAttribute("major", stu.getStudentDetail().getClazz().getMajor().getName());
        model.addAttribute("grade", stu.getStudentDetail().getClazz().getGrade());
        model.addAttribute("class", stu.getStudentDetail().getClazz().getName());
        model.addAttribute("phone", stu.getStudentDetail().getPhone());

        //处理教材信息
        if(user.getType().equals(UserType.STUDENT))
        {
            List<UseBook> usebook = studentbookservice.getUseBookByStudentId(user.getId());
            for(UseBook ub:usebook)
            {
                Map<String ,String> pam = new HashMap<String, String>();
                pam.put("lesson_code" , ub.getLesson().getLessonDetail().getLessonCode());
                pam.put("lesson_name" , ub.getLesson().getName());
                pam.put("book_name" , ub.getBook().getBookDetail().getName());
                pam.put("book_code" , ub.getBook().getBookDetail().getISBN());
                pam.put("book_author" , ub.getBook().getBookDetail().getAuthor());
                pam.put("book_publisher" , ub.getBook().getBookDetail().getInstitute());
//                pam.put("book_num" , "" + bookorderservice.getNumByIdAndBid(user.getId(), ub.getBook().getId()));
                bookinfo.add(pam);
            }
        }

        model.addAttribute("bookinfo", bookinfo);
        return "stu/bookOrder";
    }
}
