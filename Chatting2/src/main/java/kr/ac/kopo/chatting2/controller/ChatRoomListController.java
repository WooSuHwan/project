package kr.ac.kopo.chatting2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.chatting2.model.ChatRoom;
import kr.ac.kopo.chatting2.model.ChatRoomList;
import kr.ac.kopo.chatting2.service.ChatRoomListService;

@Controller
@RequestMapping("/chatroomlist")
public class ChatRoomListController {
	
	@Autowired
	ChatRoomListService service;
	// 채팅방 리스트 만드는 코드
	@RequestMapping("")
	String chatroomlist(Model model) {
		List<ChatRoomList> list = service.list();
		
		model.addAttribute("list", list);
		
		return "/chatroomlist/chatroomlist";
	}
	// 새 채팅방 만드는 코드
	@GetMapping("/newchatting")
	String newChatting(HttpSession session) {
		if(session.getAttribute("code") == null) {
			return "redirect:login/login";
		}
		
		ChatRoomList chatroomlist = new ChatRoomList();
		chatroomlist.setUser_code((Integer)session.getAttribute("code"));
		chatroomlist.setName((String) session.getAttribute("name"));
		
		service.create(chatroomlist);
		
		return "redirect:/chatroomlist/" + chatroomlist.getCode();
	}
	// 채팅방을 들어가는 코드
	@GetMapping("/{chatroomlist_code}")
	String chatroom(@PathVariable(name="chatroomlist_code") int code, Model model, HttpSession session) {
	
		if(session.getAttribute("code") == null) {
			return "redirect:/login/login";
		}
		
		ChatRoomList chatroomlist = service.getChatroom(code);
		model.addAttribute("chatting", chatroomlist);
		
		return "chatroomlist/chatting";
	}
	// 채팅방을 삭제하는 코드
	@GetMapping("/delete/{chatroomlist_code}")
	String delete(@PathVariable(name="chatroomlist_code") int code, HttpSession session, Model model) {
		
		if(session.getAttribute("code") == null) {
			return "redirect:/login/login";
		}
		
		ChatRoom chatroom = new ChatRoom();
		chatroom.setUser_code((Integer)session.getAttribute("code"));
		chatroom.setCode(code);
		
		service.delete(chatroom);
		
		return "redirect:/chatroomlist";
	} 
	
}
