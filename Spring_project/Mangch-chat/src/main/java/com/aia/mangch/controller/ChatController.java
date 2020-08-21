package com.aia.mangch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.model.ChatRoomInfo;
import com.aia.mangch.model.DelChatRoomInfo;
import com.aia.mangch.model.InsertChatMsgInfo;
import com.aia.mangch.model.NewMsgForBadge;
import com.aia.mangch.service.ChatMsgListService;
import com.aia.mangch.service.ChatRoomDelService;
import com.aia.mangch.service.ChatRoomListService;
import com.aia.mangch.service.NewMsgService;
import com.aia.mangch.service.sendMsgService;
@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatRoomListService listsv;
	@Autowired
	private ChatMsgListService msgListsv;
	@Autowired
	private NewMsgService newMsgsv;
	@Autowired
	private sendMsgService sendsv;
	@Autowired
	private ChatRoomDelService roomDelsv;
	
	
	//채팅방 리스트
	@CrossOrigin //크로스 도메인 이슈 --> 보안문제때문에 적어줘야함
	@GetMapping("/chatRoom")
	public List<ChatRoomInfo> getChatList(@RequestParam("uNick") String nick){
		return listsv.getChatList(nick);
	}
	
	//채팅방 삭제
	@CrossOrigin
	@PostMapping("/chatRoom")
	public int delChatRoom(
				DelChatRoomInfo info,
				HttpServletRequest req) {
		return roomDelsv.delChatRoom(info,req);
	}
	
	//내가선택한 채팅방의 메세지리스트
	@CrossOrigin
	@GetMapping("/{idx}")
	public List<ChatMsgInfo> getMsgList(
				@PathVariable("idx") int idx,
				@RequestParam("uNick") String nick) {
		return msgListsv.getMsgList(idx,nick);
	}
	
	//나에게 온 새로운 메세지 개수 받아오기(채팅방 별로 정렬)
	@CrossOrigin
	@GetMapping
	public List<NewMsgForBadge> getNewMsg(
			@RequestParam("uNick") String nick
			//@RequestParam("idx") int idx
			) {
		return newMsgsv.getNewMsg(nick);
	}
	
	//새로운 메세지 전송
	@CrossOrigin
	@PostMapping
	public ChatMsgInfo insertMsg(InsertChatMsgInfo chat,HttpServletRequest req) {
		ChatRoomInfo chatRoom = chat.setRoomInfo();
		return sendsv.sendMsg(chat,chatRoom,req);
//		return 1;
	}
}
