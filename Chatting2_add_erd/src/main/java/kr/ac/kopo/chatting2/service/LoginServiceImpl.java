package kr.ac.kopo.chatting2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chatting2.dao.LoginDao;
import kr.ac.kopo.chatting2.model.User;
import kr.ac.kopo.chatting2.util.AES256Util;
import kr.ac.kopo.chatting2.util.SHA256Util;

@Service
public class LoginServiceImpl implements LoginService {
	
	AES256Util aes256 = new AES256Util(); // 양반향 암호화
	SHA256Util sha256 = new SHA256Util(); // 단반향 암호화
	
	@Autowired
	LoginDao dao;
	// 로그인시 암호화를 시킨 후 대조
	@Override
	public User check(String id, String pw) {
		String encryptedId = aes256.encrypt(id);
		String encryptedPw = sha256.encrypt(pw);
		
		User user = dao.check(encryptedId, encryptedPw);
		if(user == null) {
			return null;
		} else {
			user.setName(aes256.decrypt(user.getName()));
			return user;
		}

	}

}
