package ver06;

public class PhoneCafeInfo extends PhoneInfo {

	private String cafeName;
	private String nickName;
	
	public PhoneCafeInfo(String name, 
						 String pNumber, 
						 String addr, 
						 String email) {
		super(name, pNumber, addr, email);
		// TODO Auto-generated constructor stub
	}

	PhoneCafeInfo(String name, 
				  String phoneNumber, 
				  String addr, 
				  String email,
				  String cafeName,
				  String nickName) {
		super(name, phoneNumber, addr, email);
		this.cafeName = cafeName;
		this.nickName = nickName;
		
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
}
