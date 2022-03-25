package kr.ac.kopo.chatting2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.chatting2.model.Suggest;
import kr.ac.kopo.chatting2.service.SuggestService;

@Controller
@RequestMapping("/suggest")
public class SuggestController {

	@Autowired
	SuggestService service;
	
	@GetMapping("")
	String list(Model model) {
		List<Suggest> list = service.list();
		
		model.addAttribute("list", list);
		
		return "/suggest/list";
	}
	
	@GetMapping("/add")
	String add(HttpSession session) {
		if(session == null)
			return "redirect:/login/login";
		
		return "/suggest/add";
	}
	
	@PostMapping("/add")
	String add(Suggest suggest, HttpSession session) {
		if(suggest.getStory() == "") {
			return "redirect:/suggest/list";
		}
		if(suggest.getName() == "") {
			return "redirect:/suggest/list";
		}
		suggest.setUser_code((int) session.getAttribute("code"));
		service.add(suggest);
		
		return "redirect:/suggest/";
	}
	
	@GetMapping("{suggest_code}")
	String enter(Model model, @PathVariable(name="suggest_code") int code) {
		
		Suggest suggest = service.enter(code);
		
		model.addAttribute("suggest", suggest);
		
		return "suggest/enter";
	}
	
	@GetMapping("/delete/{suggest_code}")
	String delete(@PathVariable(name="suggest_code") int code, HttpSession session, Model model) {
		
		if(session.getAttribute("code") == null) {
			return "redirect:/login/login";
		}
		
		Suggest suggest = new Suggest();
		suggest.setUser_code((Integer)session.getAttribute("code"));
		suggest.setCode(code);
		
		service.delete(suggest);
		
		return "redirect:/suggest";
	}
	
}
