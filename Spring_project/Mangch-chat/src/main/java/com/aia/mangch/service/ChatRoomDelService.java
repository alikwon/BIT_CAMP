package com.aia.mangch.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.DelChatRoomInfo;

@Service
public class ChatRoomDelService {
	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;
	
	public int delChatRoom(DelChatRoomInfo info) {
		dao= st.getMapper(ChatDao.class);
		if(info.getDelUser()!=null) {
			return dao.delChatRoom(info);
		}else {
			dao.updateRoomDate(info.getRoomIdx());;
			return dao.updateDelUser(info);
		}
	}

}
