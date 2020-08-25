package com.aia.mangch.model;

public class RequestInfo {
	private int reqIdx;
	private String reqNick;
	private String reqTitle;
	private String reqLoc;
	
	
	public String getReqTitle() {
		return reqTitle;
	}
	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}
	public int getReqIdx() {
		return reqIdx;
	}
	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
	}
	public String getReqNick() {
		return reqNick;
	}
	public void setReqNick(String reqNick) {
		this.reqNick = reqNick;
	}
	public String getReqLoc() {
		return reqLoc;
	}
	public void setReqLoc(String reqLoc) {
		this.reqLoc = reqLoc;
	}
	
}
