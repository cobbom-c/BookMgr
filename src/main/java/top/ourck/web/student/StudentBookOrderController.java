package top.ourck.web.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ourck.beans.UseBook;
import top.ourck.beans.UserType;
import top.ourck.beans.util.User;
import top.ourck.beans.util.UserHolder;
import top.ourck.service.BookOrderService;
import top.ourck.service.StudentBookService;
import top.ourck.service.StudentService;

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
        List<Map<String, Object>> bookinfo = null;
        User user = userholder.getUser();

        //处理学生信息
        model.addAttribute("name", studentservice.getById(user.getId()).getStudentDetail().getName());
        model.addAttribute("id", user.getUserName());
        model.addAttribute("major", studentservice.getById(user.getId()).getStudentDetail().getClazz().getMajor().getName());
        model.addAttribute("grade", studentservice.getById(user.getId()).getStudentDetail().getClazz().getGrade());
        model.addAttribute("class", studentservice.getById(user.getId()).getStudentDetail().getClazz().getName());
        model.addAttribute("phone", studentservice.getById(user.getId()).getStudentDetail().getPhone());

        //处理教材信息
        if(user.getType().equals(UserType.STUDENT))
        {
            List<UseBook> usebook = studentbookservice.getUseBookByStudentId(user.getId());
            for(UseBook ub:usebook)
            {
                Map<String ,Object> pam = null;
                pam.put("lessoncode" ,ub.getLesson().getLessonDetail().getLessonCode());
                pam.put("lessoncode" ,ub.getLesson().getName());
                pam.put("bookname" ,ub.getBook().getBookDetail().getName());
                pam.put("bookcode" ,ub.getBook().getBookDetail().getISBN());
                pam.put("bookauthor" ,ub.getBook().getBookDetail().getAuthor());
                pam.put("bookpublisher" ,ub.getBook().getBookDetail().getInstitute());
                pam.put("num" ,bookorderservice.getNumByIdAndBid(user.getId(), ub.getBook().getId()));
                bookinfo.add(pam);
            }
        }

        model.addAttribute("bookinfo", bookinfo);
        return "book/Order";
    }
}