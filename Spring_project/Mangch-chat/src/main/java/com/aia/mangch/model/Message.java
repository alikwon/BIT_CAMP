package com.aia.mangch.model;

import java.util.Date;

public class Message {
	private String code;
	private int idx;
	private int roomIdx;
	private String sender;
	private String receiver;
	private String text;
	private String img;
	private String uri;
	private long date = new Date().getTime();
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "Message [code=" + code + ", idx=" + idx + ", roomIdx=" + roomIdx + ", sender=" + sender + ", receiver="
				+ receiver + ", text=" + text + ", img=" + img + ", uri=" + uri + "]";
	}
}
