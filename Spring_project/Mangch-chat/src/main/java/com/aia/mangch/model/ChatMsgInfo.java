package com.aia.mangch.model;

import java.util.Date;

public class ChatMsgInfo {
	private int idx;
	private int roomIdx;
	private String sender;
	private String receiver;
	private String text;
	private String img;
	private Date date;
	private int readChk;
	
	public ChatMsgInfo(int idx, int roomIdx, String sender, String receiver, String text, String img, Date date,
			int readChk) {
		this.idx = idx;
		this.roomIdx = roomIdx;
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		this.img = img;
		this.date = date;
		this.readChk = readChk;
	}
	
	public ChatMsgInfo() {}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReadChk() {
		return readChk;
	}
	public void setReadChk(int readChk) {
		this.readChk = readChk;
	}
	
	
}
