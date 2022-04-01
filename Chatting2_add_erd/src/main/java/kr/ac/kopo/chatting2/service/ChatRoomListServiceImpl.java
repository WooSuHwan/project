package kr.ac.kopo.chatting2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chatting2.dao.ChatRoomListDao;
import kr.ac.kopo.chatting2.model.ChatRoom;
import kr.ac.kopo.chatting2.model.ChatRoomList;

@Service
public class ChatRoomListServiceImpl implements ChatRoomListService {

	@Autowired
	ChatRoomListDao dao;
	
	@Override
	public List<ChatRoomList> list() {
		return dao.list();
	}
		
	@Override
	public void create(ChatRoomList chatroomlist) {
		dao.create(chatroomlist);
	}

	@Override
	public ChatRoomList getChatroom(int code) {
		return dao.getChatroom(code);
	}

	@Override
	public void delete(ChatRoom chatroom) {
		dao.delete(chatroom);
	}
	
}
