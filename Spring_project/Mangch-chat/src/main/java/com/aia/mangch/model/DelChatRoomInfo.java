package com.aia.mangch.model;

public class DelChatRoomInfo {
	private int roomIdx;
	private String delUser;
	private String loginUser;
	
	
	public int getRoomIdx() {
		return roomIdx;
	}
	public void setRoomIdx(int roomIdx) {
		this.roomIdx = roomIdx;
	}
	public String getDelUser() {
		return delUser;
	}
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	@Override
	public String toString() {
		return "DelChatRoomInfo [roomIdx=" + roomIdx + ", delUser=" + delUser + ", loginUser=" + loginUser + "]";
	}
	
}
