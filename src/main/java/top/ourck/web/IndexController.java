package top.ourck.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(value = {"", "/"})
	public String index() {
		return "redirect:/login/auth";
	}
}
