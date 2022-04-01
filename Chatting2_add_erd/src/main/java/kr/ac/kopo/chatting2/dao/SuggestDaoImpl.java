package kr.ac.kopo.chatting2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.chatting2.model.Suggest;

@Repository
public class SuggestDaoImpl implements SuggestDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Suggest> list() {
		return sql.selectList("suggest.list");
	}

	@Override
	public void add(Suggest suggest) {
		sql.insert("suggest.add", suggest);
	}

	@Override
	public Suggest enter(int code) {
		return sql.selectOne("suggest.enter", code);
	}

	@Override
	public void delete(Suggest suggest) {
		sql.delete("suggest.delete", suggest);
	}

}
