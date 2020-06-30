package ver05;

//phoneinfo클래스 상속을 통해서 새로운 클래스를 정의
public class PhoneUnivInfo extends PhoneInfor {
	private String major;
	private String grade;
	
	PhoneUnivInfo(String name, 
				  String phoneNumber, 
				  String addr,
				  String email, 
				  String major, 
				  String grade){
		super(name, phoneNumber, addr, email);
		this.major=major;
		this.grade=grade;
		
	}

	@Override
	public void showAllInfo() {
//		super.showAllData();
		showBasicInfo();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
	}
	
}
