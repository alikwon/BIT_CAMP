package com.aia.mangch.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.NewMsgForBadge;

@Service
public class NewMsgService {
	
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public List<NewMsgForBadge> getNewMsg(String nick) {
		dao= st.getMapper(ChatDao.class);
		return dao.newMsgList(nick);
	}
}
