package com.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/user")
	public String user() {
		return "user.jsp";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "admin.jsp";
	}
	@RequestMapping("/admin2")
	public String admin2() {
		return "admin2.jsp";
	}
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	@RequestMapping("/logout-page")
	public String logout() {
		return "logout.jsp";
	}
}
