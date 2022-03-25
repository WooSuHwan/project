package kr.ac.kopo.chatting2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chatting2.model.ChatRoom;

@Repository
public class ChatroomDaoImpl implements ChatRoomDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int newchat(ChatRoom chatroom) {
		return sql.insert("chatroom.newchat", chatroom);
	}

	@Override
	public List<ChatRoom> getList(Integer room_code) {
		return sql.selectList("chatroom.getList", room_code);
	}

}
