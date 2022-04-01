package kr.ac.kopo.chatting2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.chatting2.model.User;
import kr.ac.kopo.chatting2.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	final String path = "login/";
	
	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	String login() {
		return path + "/login";
	}
	// 로그인
	@PostMapping("/login")
	String login(String id, String pw, HttpSession session) {
		User user = service.check(id, pw);

		if(user == null) {
			return "redirect:/login/login?wrong=true";
		} else {
			session.setAttribute("code", user.getCode());
			session.setAttribute("name", user.getName());
			return "redirect:/";
		}
	}
	// 로그아웃
	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
