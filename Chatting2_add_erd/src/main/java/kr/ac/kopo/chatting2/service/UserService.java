package kr.ac.kopo.chatting2.service;

import kr.ac.kopo.chatting2.model.User;

public interface UserService {

	void add(User user);

	boolean confirm(String id);

}
