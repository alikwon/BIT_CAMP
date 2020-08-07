package com.mm.aa.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegInfo {
	private String uid;
	private String upw;
	private String uname;
	private MultipartFile uphoto;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public MultipartFile getUphoto() {
		return uphoto;
	}
	public void setUphoto(MultipartFile uphoto) {
		this.uphoto = uphoto;
	}
	public Member setMember() {
		return new Member(uid, upw, uname);
	}
	@Override
	public String toString() {
		return "MemberRegInfo [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto + "]";
	}
	
	
}
