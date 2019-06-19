package top.ourck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import top.ourck.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = {"", "/", "/index"})
	public String index() {
		return "/admin/index";
	}
	
	@RequestMapping("/logout")
	public String logout(@CookieValue("ticket") String ticket) {
		adminService.logout(ticket);
		return "redirect:/login/auth";
	}

}
