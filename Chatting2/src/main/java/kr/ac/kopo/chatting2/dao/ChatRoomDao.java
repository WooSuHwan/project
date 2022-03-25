package kr.ac.kopo.chatting2.dao;

import java.util.List;

import kr.ac.kopo.chatting2.model.ChatRoom;

public interface ChatRoomDao {

	int newchat(ChatRoom chatroom);

	List<ChatRoom> getList(Integer room_code);

}
