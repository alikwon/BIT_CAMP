package guestbook.model;

public class Message {
	
	private int mid; //
	private String uname;
	private String pw;
	private String msg;
	
	public Message(int mid, String uname, String pw, String msg) {
		this.mid = mid;
		this.uname = uname;
		this.pw = pw;
		this.msg = msg;
	}

	public Message() {
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", uname=" + uname + ", pw=" + pw + ", msg=" + msg + "]";
	}
	
	
}
