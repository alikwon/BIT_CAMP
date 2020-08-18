package com.aia.mangch.dao;

import java.util.List;

import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.ChatRoomInfo;
import com.aia.mangch.model.DelChatRoomInfo;
import com.aia.mangch.model.NewMsgForBadge;


public interface ChatDao {

	List<ChatRoomInfo> selectChatRoomList(String nick);

	List<ChatMsgInfo> selectMsgList(int idx, String nick);

	void readMsg(String nick, int idx);

	List<NewMsgForBadge> newMsgList(String nick);

	int insertMsg(ChatMsgInfo chat);

	void updateRoomDate(int roomIdx);

	int roomExistChk(int roomIdx);

	void createChatRoom(ChatRoomInfo chatRoom);

	void insertMsgWithImg(ChatMsgInfo chat);

	int delChatRoom(DelChatRoomInfo info);

	int updateDelUser(DelChatRoomInfo info);

	String getRequestTitle(int reqIdx);



}
