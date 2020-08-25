package com.aia.mangch.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.RequestInfo;

@Service
public class ChatMsgService {
	
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
		RequestInfo ri = null;
		if(idx!=0) {
			ri = dao.selectRequest(idx);
		}else {
			ri=new RequestInfo();
			ri.setReqLoc("(알 수없음)");
			ri.setReqTitle("(삭제된 게시물 입니다)");
			ri.setReqNick("(알 수 없음)");
		}
		return ri;
	}

	public int readMsg(int idx, String nick) {
		dao =st.getMapper(ChatDao.class);
		return dao.readMsg(nick,idx);
	}
}
