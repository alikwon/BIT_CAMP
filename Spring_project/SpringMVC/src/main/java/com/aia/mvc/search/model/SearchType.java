package com.aia.mvc.search.model;

public class SearchType {
	
	//1. 제목검색
	//2. 내용검색
	//3. 제목+내용검색
	private int tno;
	private String type;
	
	
	
	public SearchType(int tna, String type) {
		this.tno = tna;
		this.type = type;
	}

	public SearchType() {}
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tna) {
		this.tno = tna;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SearchType [tna=" + tno + ", type=" + type + "]";
	}
	
	
}
