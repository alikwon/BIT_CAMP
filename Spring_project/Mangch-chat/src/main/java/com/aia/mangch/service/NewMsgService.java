package com.aia.mangch.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;

@Service
public class NewMsgService {
	
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public int getNewMsg(int idx, String nick) {
		dao= st.getMapper(ChatDao.class);
		return dao.newMsgCount(idx,nick);
	}
}
