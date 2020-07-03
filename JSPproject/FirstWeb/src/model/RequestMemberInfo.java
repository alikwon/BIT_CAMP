package model;

public class RequestMemberInfo {
	private String id;
	private String pw;
	private String uName;
	
	public RequestMemberInfo() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "requestMemberInfo [id=" + id + ", pw=" + pw + ", uName=" + uName + "]";
	}

	
}
