package kr.ac.kopo.chatting2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chatting2.model.ChatRoom;
import kr.ac.kopo.chatting2.model.ChatRoomList;

@Repository
public class ChatRoomListDaoImpl implements ChatRoomListDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<ChatRoomList> list() {
		return sql.selectList("chatroomlist.list");
	}

	@Override
	public void create(ChatRoomList chatroomlist) {
		sql.insert("chatroomlist.create", chatroomlist);
	}

	@Override
	public ChatRoomList getChatroom(int code) {
		return sql.selectOne("getchatroom", code);
	}

	@Override
	public void delete(ChatRoom chatroom) {
		sql.delete("chatroomlist.delete", chatroom);
	}

}
