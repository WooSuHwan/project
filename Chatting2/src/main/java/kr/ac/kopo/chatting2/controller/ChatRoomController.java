package kr.ac.kopo.chatting2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.chatting2.model.ChatRoom;
import kr.ac.kopo.chatting2.service.ChatRoomService;

@Controller
@RequestMapping("/chatroom")
public class ChatRoomController {

	@Autowired
	ChatRoomService service;
	
	@PostMapping("/new")
	@ResponseBody
	String chatroom(HttpSession session, ChatRoom chatroom) {
		
		if(session.getAttribute("code") == null) {
			return "redirect:/login/login";
		}
		
		System.out.println("작동");
		chatroom.setUser_code((Integer) session.getAttribute("code"));
		chatroom.setChat_user_name((String) session.getAttribute("name"));
		
		int chatstory = service.newchat(chatroom);
		
		if(chatstory > 0) {
			return "true";
		} else {
			return "false";
		}
	}
	// 채팅방 내용을 불러오는 코드 
	@GetMapping("{chatroomlist_code}/list")
	@ResponseBody
	List<ChatRoom> getList(HttpSession session, @PathVariable(name="chatroomlist_code") Integer room_code) {
		
		List<ChatRoom> story = service.getList(room_code);
		
		return story;
	}
	
}
