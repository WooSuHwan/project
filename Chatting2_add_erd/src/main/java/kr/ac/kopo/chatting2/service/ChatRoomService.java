package kr.ac.kopo.chatting2.service;

import java.util.List;

import kr.ac.kopo.chatting2.model.ChatRoom;

public interface ChatRoomService {

	int newchat(ChatRoom chatroom);

	List<ChatRoom> getList(Integer room_code);

}
