package com.aia.mangch.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.RequestInfo;

@Service
public class ChatMsgListService {
	
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public List<ChatMsgInfo> getMsgList(int idx, String nick) {
		dao = st.getMapper(ChatDao.class);
		dao.readMsg(nick,idx);
		return dao.selectMsgList(idx,nick);
	}
	
	public String getMemberImg(String nick) {
		dao = st.getMapper(ChatDao.class);
		String img = dao.selectMemberImg(nick);
		System.out.println(img);
		return img; 
	}
	
	public RequestInfo getRequestInfo(int idx) {
		dao = st.getMapper(ChatDao.class);
		return dao.selectRequest(idx);
	}
}
