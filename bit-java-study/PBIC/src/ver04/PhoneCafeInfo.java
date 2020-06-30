package ver04;

public class PhoneCafeInfo extends PhoneInfor {

	private String cafeName;
	private String nickName;
	
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

	@Override
	void showAllData() {
		super.showAllData();
		System.out.println("카페이름 : "+cafeName);
		System.out.println("닉네임 : "+nickName);
	}
	
}
