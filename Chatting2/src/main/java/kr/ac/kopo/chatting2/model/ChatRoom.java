package kr.ac.kopo.chatting2.model;

import java.sql.Date;

public class ChatRoom {
	int code;
	int user_code;
	int chatroomlist_code;
	String story;
	Date time;
	String chat_user_name;

	public String getChat_user_name() {
		return chat_user_name;
	}

	public void setChat_user_name(String chat_user_name) {
		this.chat_user_name = chat_user_name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	public int getChatroomlist_code() {
		return chatroomlist_code;
	}

	public void setChatroomlist_code(int chatroomlist_code) {
		this.chatroomlist_code = chatroomlist_code;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
