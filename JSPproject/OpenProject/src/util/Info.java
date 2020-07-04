package util;

public class Info {
	private String uid;
	private String pw;
	private String email;
	
	
	public Info(String uid, String pw, String email) {
		this.uid = uid;
		this.pw = pw;
		this.email = email;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
