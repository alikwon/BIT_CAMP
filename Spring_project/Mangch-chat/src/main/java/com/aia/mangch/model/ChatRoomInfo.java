package com.aia.mangch.model;

import java.util.Date;

public class ChatRoomInfo {
	private int idx;
	private String roomName;
	private int reqIdx;
	private String reqTitle;
	private String mbNick1;
	private String mbNick2;
	private Date roomDate;
	private String delUser;
	private String mbImg;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getReqIdx() {
		return reqIdx;
	}
	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
	}
	public String getReqTitle() {
		return reqTitle;
	}
	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}
	public String getMbNick1() {
		return mbNick1;
	}
	public void setMbNick1(String mbNick1) {
		this.mbNick1 = mbNick1;
	}
	public String getMbNick2() {
		return mbNick2;
	}
	public void setMbNick2(String mbNick2) {
		this.mbNick2 = mbNick2;
	}
	public Date getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(Date roomDate) {
		this.roomDate = roomDate;
	}
	public String getDelUser() {
		return delUser;
	}
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	public String getMbImg() {
		return mbImg;
	}
	public void setMbImg(String mbImg) {
		this.mbImg = mbImg;
	}
	
	
}