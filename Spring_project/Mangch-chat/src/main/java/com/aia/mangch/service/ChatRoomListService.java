package com.aia.mangch.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatRoomInfo;

@Service
public class ChatRoomListService {

	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public List<ChatRoomInfo> getChatList(String nick){
		dao = st.getMapper(ChatDao.class);
		return dao.selectChatRoomList(nick);
	}
	
}
