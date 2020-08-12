package com.aia.mangch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mangch.model.ChatMsgInfo;
import com.aia.mangch.service.ChatMsgListService;
import com.aia.mangch.service.NewMsgService;

@RestController
@RequestMapping("/chat")
public class MsgController {
	
	@Autowired
	private ChatMsgListService mlsv;
	@Autowired
	private NewMsgService nmsv;
	
	@GetMapping("{idx}")
	public List<ChatMsgInfo> getMsgList(
				@PathVariable("idx") int idx,
				@RequestParam("uNick") String nick) {
		System.out.println(idx);
		System.out.println(nick);
		return mlsv.getMsgList(idx,nick);
	}
	@GetMapping
	public int getNewMsg(
			@RequestParam("uNick") String nick,
			@RequestParam("idx") int idx
			) {
		return nmsv.getNewMsg(idx,nick);
	}
}
