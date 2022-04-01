package kr.ac.kopo.chatting2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chatting2.dao.ChatRoomDao;
import kr.ac.kopo.chatting2.model.ChatRoom;
import kr.ac.kopo.chatting2.util.AES256Util;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

	@Autowired
	ChatRoomDao dao;
	
	@Override
	public int newchat(ChatRoom chatroom) {
		return dao.newchat(chatroom);
	}

	@Override
	public List<ChatRoom> getList(Integer room_code) {
		List<ChatRoom> list = dao.getList(room_code);
		
		for(int i=0; list.size()>i; i++) {
			ChatRoom one = list.get(i); // 리스트에서 순서가 i인 챗룸 가져오기
			String decryptedName = AES256Util.decrypt(one.getChat_user_name()); // 이름 복호화
			one.setChat_user_name(decryptedName); // 챗룸에 복호화된 이름 저장
			list.set(i, one); // 리스트에 챗룸 저장
			
			// 줄이면 아래 코드
			// list.get(i).setChat_user_name(AES256Util.decrypt(list.get(i).getChat_user_name()));
		}
		
		return list;
		
		/**for(int i=0; list.size()>i; i++) {
		list.get(i).setChat_user_name(AES256Util.decrypt(list.get(i).getChat_user_name()));
		// java static에 대해서 공부하면 이해될듯
	}
	
	return list;*/

	}
	
}
