package ver06;

//phoneinfo클래스 상속을 통해서 새로운 클래스를 정의
public class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private int year;
	
	
	public PhoneUnivInfo(String name, 
						 String pNumber, 
						 String addr, 
						 String email) {
		super(name, pNumber, addr, email);
	}

	PhoneUnivInfo(String name, 
				  String phoneNumber, 
				  String addr,
				  String email, 
				  String major, 
				  int year){
		super(name, phoneNumber, addr, email);
		this.major=major;
		this.year=year;
		
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


}
