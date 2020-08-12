package com.aia.mangch.model;

public class ChatRoomInfo {
	private int idx;
	private int reqIdx;
	private String reqTitle;
	private String mbNick1;
	private String mbNick2;
	
	
	public ChatRoomInfo(int idx, int reqIdx, String reqTitle, String mbNick1, String mbNick2) {
		this.idx = idx;
		this.reqIdx = reqIdx;
		this.reqTitle = reqTitle;
		this.mbNick1 = mbNick1;
		this.mbNick2 = mbNick2;
	}
	
	public ChatRoomInfo() {}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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

	
}
