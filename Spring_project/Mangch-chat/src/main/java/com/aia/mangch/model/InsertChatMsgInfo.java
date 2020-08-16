package com.aia.mangch.model;

import org.springframework.web.multipart.MultipartFile;

public class InsertChatMsgInfo {
	private int roomIdx;
	private String sender;
	private String receiver;
	private String text;
	private MultipartFile msgPhoto;
	private int reqIdx;
	
	public InsertChatMsgInfo(int roomIdx, String sender, String receiver, String text, MultipartFile msgPhoto,
			int reqIdx) {
		this.roomIdx = roomIdx;
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		this.msgPhoto = msgPhoto;
		this.reqIdx = reqIdx;
	}

	public InsertChatMsgInfo() {}
	
	public int getRoomIdx() {
		return roomIdx;
	}
	public void setRoomIdx(int roomIdx) {
		this.roomIdx = roomIdx;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MultipartFile getMsgPhoto() {
		return msgPhoto;
	}
	public void setMsgPhoto(MultipartFile msgPhoto) {
		this.msgPhoto = msgPhoto;
	}
	public int getReqIdx() {
		return reqIdx;
	}
	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
	}

	public ChatRoomInfo setRoomInfo() {
		ChatRoomInfo ri=new ChatRoomInfo();
		ri.setMbNick1(sender);
		ri.setMbNick2(receiver);
		ri.setReqIdx(reqIdx);
		return ri;
	}

	public ChatMsgInfo setChatMsgInfo() {
		ChatMsgInfo cmi = new ChatMsgInfo();
		cmi.setRoomIdx(roomIdx);
		cmi.setSender(sender);
		cmi.setReceiver(receiver);
		cmi.setReqIdx(reqIdx);
		return cmi;
	}

	@Override
	public String toString() {
		return "InsertChatMsgInfo [roomIdx=" + roomIdx + ", sender=" + sender + ", receiver=" + receiver + ", text="
				+ text + ", msgPhoto=" + msgPhoto + ", reqIdx=" + reqIdx + "]";
	}

	
	
}
