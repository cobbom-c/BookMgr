package top.ourck.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.ourck.beans.Admin;
import top.ourck.beans.Student;
import top.ourck.beans.Teacher;
import top.ourck.beans.UserType;
import top.ourck.beans.util.User;

@Service
public class UserService {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LoginTicketService ltService;
	
	/**
	 * 根据给定的用户名和密码完成验证。
	 * @param userName 用户名
	 * @param password 密码
	 * @return 参数。验证成功返回的Map里包含有通过验证的用户（User）实体。
	 */
	public Map<String, Object> getAuth(String userName, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		// HINT 善用短路运算！
		Map<String, Object> info = null;
		if((info = studentService.getAuth(userName, password)).get("success").equals("true") ||
			(info = teacherService.getAuth(userName, password)).get("success").equals("true") ||
			(info = adminService.getAuth(userName, password)).get("success").equals("true")) {
			User user = null;
			switch((UserType)info.get("type")) {
			case STUDENT: user = User.wrap((Student)info.get("user")); break;
			case TEACHER: user = User.wrap((Teacher)info.get("user")); break;
			case ADMIN: user = User.wrap((Admin)info.get("user")); break;
			}
			result.put("success", "true");
			result.put("user", user);
			
			// 下发ticket
			result.put("ticket", ltService.genLoginTicket(user));
		}
		else {
			result.put("success", "false");
		}
		
		return result;
	}
	
}
