package com.aia.mangch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mangch.model.ChatRoomInfo;
import com.aia.mangch.service.ChatRoomListService;

@RestController
@RequestMapping("/chatRoom")
public class ChatRoomController {
	
	@Autowired
	ChatRoomListService listsv;
	//리스트 보기 : Json응답  GET| /chats
	@GetMapping
	public List<ChatRoomInfo> getChatList(@RequestParam("uNick") String nick){
		return listsv.getChatList(nick);
//		return null;
	}
}
