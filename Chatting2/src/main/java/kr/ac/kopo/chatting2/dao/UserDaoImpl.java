package kr.ac.kopo.chatting2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chatting2.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SqlSession sql;
	// 회원가입
	@Override
	public void add(User user) {
		sql.insert("user.add", user);
	}
	// 중복확인
	@Override
	public int idCount(String id) {
		return sql.selectOne("user.idCount", id);
	}
	
}
