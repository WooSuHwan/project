package kr.ac.kopo.chatting2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.chatting2.model.User;
import kr.ac.kopo.chatting2.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	final String path = "user/";
	
	@Autowired
	UserService service;
	
	@GetMapping("/add")
	String add() {
		return path + "/add";
	}
	// 회원가입 및 등록시 중복확인
	@PostMapping("/add")
	String add(User user) {
		if(service.confirm(user.getId())) {
			
			return "redirect:add";
		}
		
		service.add(user);
		
		return "redirect:..";
	}
	// 중복확인 메소드
	@ResponseBody
	@PostMapping("/same")
	String confirm(String user_id) {
		boolean overlap = service.confirm(user_id);
		if(overlap == true) {
			return "overlap";
		} else {
			return "use";
		}
	}
}
