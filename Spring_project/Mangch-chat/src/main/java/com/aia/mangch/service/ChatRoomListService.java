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
		String title = null;
		List<ChatRoomInfo> list = dao.selectChatRoomList(nick);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getReqIdx()!=0) {
				title = dao.getRequestTitle(list.get(i).getReqIdx());
				list.get(i).setReqTitle(title);
			}else if(list.get(i).getReqIdx()==0){
				list.get(i).setReqTitle("(삭제된 게시물입니다)");
			}
		}
		return list;
	}
	
}
