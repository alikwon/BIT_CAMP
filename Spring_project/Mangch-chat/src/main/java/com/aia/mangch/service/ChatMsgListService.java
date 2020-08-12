package com.aia.mangch.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatMsgInfo;

@Service
public class ChatMsgListService {
	
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public List<ChatMsgInfo> getMsgList(int idx, String nick) {
		dao = st.getMapper(ChatDao.class);
		dao.readMsg(nick);
		return dao.selectMsgList(idx);
	}
	
	
}
