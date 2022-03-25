package kr.ac.kopo.chatting2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chatting2.dao.UserDao;
import kr.ac.kopo.chatting2.model.User;
import kr.ac.kopo.chatting2.util.AES256Util;
import kr.ac.kopo.chatting2.util.SHA256Util;

@Service
public class UserServiceImpl implements UserService {

	AES256Util aes256 = new AES256Util(); // 양반향 암호화
	SHA256Util sha256 = new SHA256Util(); // 단반향 암호화
	
	@Autowired
	UserDao dao;
	//회원가입
	@Override
	public void add(User user) {
		// 양반향(sex는 스킵)
		user.setId(aes256.encrypt(user.getId())); 
		user.setName(aes256.encrypt(user.getName()));
		user.setBirth(aes256.encrypt(user.getBirth()));
		user.setTell(aes256.encrypt(user.getTell()));
		// 단반향
		user.setPw(sha256.encrypt(user.getPw()));
		
		dao.add(user);
	}
	//중복확인
	@Override
	public boolean confirm(String id) {
		AES256Util aes256 = new AES256Util(); // 양반향 암호화
		
		int count = dao.idCount(aes256.encrypt(id));
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}

}
