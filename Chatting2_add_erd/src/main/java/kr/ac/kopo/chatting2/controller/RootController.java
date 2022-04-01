package kr.ac.kopo.chatting2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
}
