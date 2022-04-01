package kr.ac.kopo.chatting2.dao;

import kr.ac.kopo.chatting2.model.User;

public interface UserDao {

	void add(User user);

	int idCount(String id);

}
