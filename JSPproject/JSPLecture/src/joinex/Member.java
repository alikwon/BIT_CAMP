package joinex;

public class Member {
	private String id;
	private String name;
	private String pw;
	private String gender;
	
	public Member(String id, String name, String pw, String gender) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.gender = gender;
	}

	public Member() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
