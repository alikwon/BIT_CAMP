package com.aia.mangch.dao;

import java.util.List;
import java.util.Map;

import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.ChatRoomInfo;
import com.aia.mangch.model.DelChatRoomInfo;
import com.aia.mangch.model.NewMsgForBadge;
import com.aia.mangch.model.RequestInfo;
import com.aia.mangch.model.RequestTitleInfo;


public interface ChatDao {

	List<ChatRoomInfo> selectChatRoomList(String nick);

	List<ChatMsgInfo> selectMsgList(int idx, String nick);

	int readMsg(String nick, int idx);

	List<NewMsgForBadge> newMsgList(String nick);

	int insertMsg(ChatMsgInfo chat);

	void updateRoomDate(int roomIdx);

	int roomExistChk(int roomIdx);

	void createChatRoom(ChatRoomInfo chatRoom);

	void insertMsgWithImg(ChatMsgInfo chat);

	int delChatRoom(DelChatRoomInfo info);

	int updateDelUser(DelChatRoomInfo info);

	List<String> getMsgImgPath(int roomIdx);

	List<RequestTitleInfo> selectTitleList(List<ChatRoomInfo> roomList);

	String selectMemberImg(String nick);

	RequestInfo selectRequest(int idx);


}
