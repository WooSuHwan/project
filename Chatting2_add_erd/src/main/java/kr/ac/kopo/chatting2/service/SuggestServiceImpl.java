package kr.ac.kopo.chatting2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.chatting2.dao.SuggestDao;
import kr.ac.kopo.chatting2.model.Suggest;

@Service
public class SuggestServiceImpl implements SuggestService {

	@Autowired
	SuggestDao dao;
	
	@Override
	public List<Suggest> list() {
		return dao.list();
	}

	@Override
	public void add(Suggest suggest) {
		dao.add(suggest);
	}

	@Override
	public Suggest enter(int code) {
		return dao.enter(code);
	}

	@Override
	public void delete(Suggest suggest) {
		dao.delete(suggest);
	}

}
