package kr.ac.kopo.chatting2.service;

import java.util.List;

import kr.ac.kopo.chatting2.model.ChatRoom;
import kr.ac.kopo.chatting2.model.ChatRoomList;

public interface ChatRoomListService {

	List<ChatRoomList> list();

	void create(ChatRoomList chatroomlist);

	ChatRoomList getChatroom(int code);

	void delete(ChatRoom chatroom);

}
