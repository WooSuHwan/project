package kr.ac.kopo.chatting2.service;

import java.util.List;

import kr.ac.kopo.chatting2.model.Suggest;

public interface SuggestService {

	List<Suggest> list();

	void add(Suggest suggest);

	Suggest enter(int code);

	void delete(Suggest suggest);

}
