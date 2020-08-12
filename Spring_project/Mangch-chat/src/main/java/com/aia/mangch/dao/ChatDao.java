package com.aia.mangch.dao;

import java.util.List;

import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.ChatRoomInfo;


public interface ChatDao {

	List<ChatRoomInfo> selectChatRoomList(String nick);

	List<ChatMsgInfo> selectMsgList(int idx);

	void readMsg(String nick);

	int newMsgCount(int idx, String nick);

}
