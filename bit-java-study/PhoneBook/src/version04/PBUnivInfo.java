package version04;

public class PBUnivInfo extends PBInfo {
	private String addr;
	private String email;
	private String major;
	private String year;
	
	PBUnivInfo(String name, String phoneNum, String birth, 
				String address,String email,String major,String year) {
		super(name, phoneNum, birth);
		this.addr=address;
		this.email=email;
		this.major=major;
		this.year=year;
	}
	
	PBUnivInfo(String name, String phoneNum, String address,String email,String major,String year){
		super(name, phoneNum);
		this.addr=address;
		this.email=email;
		this.major=major;
		this.year=year;
	}
	
	@Override
	void showData() {
		super.showData();
		System.out.print("    주소 : " + addr);	
		System.out.print(", 메일 : " + email);
		System.out.print(", 전공 : " + major);
		System.out.println(", 학년 : " + year);
	}	
	
	@Override
	void showBasicData() {
		super.showBasicData();
		System.out.print("    메일 : "+email);
	}
	

}
