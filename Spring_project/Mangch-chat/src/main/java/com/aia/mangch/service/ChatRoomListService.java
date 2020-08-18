package com.aia.mangch.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mangch.dao.ChatDao;
import com.aia.mangch.model.ChatRoomInfo;
import com.aia.mangch.model.RequestTitleInfo;

@Service
public class ChatRoomListService {

	@Autowired
	private SqlSessionTemplate st;
	private ChatDao dao;

	public List<ChatRoomInfo> getChatList(String nick) {
		dao = st.getMapper(ChatDao.class);
		List<ChatRoomInfo> roomList = dao.selectChatRoomList(nick);
		List<RequestTitleInfo> titleList = dao.selectRoomList(roomList);
		for (int i = 0; i < roomList.size(); i++) {
			for (int j = 0; j < titleList.size(); j++) {
				if (titleList.get(j).getRequest_idx() == roomList.get(i).getReqIdx()) {
					roomList.get(i).setReqTitle(titleList.get(j).getRequest_title());
				}
			}
			if (roomList.get(i).getReqTitle() == null) {
				roomList.get(i).setReqTitle("(삭제된 게시물 입니다)");
			}
		}
		return roomList;
	}
}
