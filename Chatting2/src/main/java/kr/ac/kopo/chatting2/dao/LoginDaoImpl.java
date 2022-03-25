package kr.ac.kopo.chatting2.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chatting2.model.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SqlSession sql;
	// HashMap을 이용한 복수의 데이터 전송
	@Override
	public User check(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		
		return sql.selectOne("user.check", map);
	}

}
