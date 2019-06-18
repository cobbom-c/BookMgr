package top.ourck.web;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.ourck.beans.UserType;
import top.ourck.beans.util.LoginTicket;
import top.ourck.beans.util.User;
import top.ourck.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/auth")
	public String login(@RequestParam(value = "target", required = false) String target,
						Model model) {
		model.addAttribute("target", target);
		return "auth/login.html";
	}
	
	@PostMapping("/auth")
	public String auth(HttpServletRequest request, HttpServletResponse response,
						@RequestParam(value = "target", required = false) String target, 
						@RequestParam("username") String userName, 
						@RequestParam("password") String password) {
		Map<String, Object> result = userService.getAuth(userName, password);
		if(result.get("success").equals("true")) {
			// TODO Auth check?
			Cookie ck = new Cookie("ticket", ((LoginTicket)result.get("ticket")).getTicket());
			ck.setPath("/"); // HINT !!!不设置的话就会按照原来/login的Path设置Cookie，这样Cookie在目标页面没法用！
			response.addCookie(ck);
			
			UserType type = ((User)result.get("user")).getType();
			if(target == null || target.equals("")) {
				switch(type) {
				case ADMIN: target = "/admin"; break;
				case TEACHER: target = "/tch"; break;
				case STUDENT: target = "/stu"; break;
				}
			}
			return "redirect:" + target;
		}
		else {
			return "forward:/login/fail"; // HINT 这样重定向的话发的是POST
		}
	}
	
	@RequestMapping("/fail")
	@ResponseBody
	public String fail() {
		return "Login failed!";
	}
}
