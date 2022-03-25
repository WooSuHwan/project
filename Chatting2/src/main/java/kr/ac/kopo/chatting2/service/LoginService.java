package kr.ac.kopo.chatting2.service;

import kr.ac.kopo.chatting2.model.User;

public interface LoginService {

	User check(String id, String pw);

}
