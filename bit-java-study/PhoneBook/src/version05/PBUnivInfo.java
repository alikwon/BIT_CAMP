package version05;

public class PBUnivInfo extends PBInfo {
	private String addr;
	private String email;
	private String major;
	private String year;

	PBUnivInfo(String name, String phoneNum, String birth, String address, String email, String major, String year) {
		super(name, phoneNum, birth);
		this.addr = address;
		this.email = email;
		this.major = major;
		this.year = year;
	}

	PBUnivInfo(String name, String phoneNum, String address, String email, String major, String year) {
		super(name, phoneNum);
		this.addr = address;
		this.email = email;
		this.major = major;
		this.year = year;
	}

	@Override
	public void showAllData() {
		super.showAllData();
		System.out.print("	주소 : " + addr);
		System.out.print(", 메일 : " + email);
		System.out.print(", 전공 : " + major);
		System.out.println(", 학년 : " + year);
	}

	//추상메서드 오버라이딩
	public void showBasicData() {

		System.out.print(" 이름 : " + getName());
		System.out.print(", 번호 : " + getPhoneNum());
		System.out.print(", 생일: " + getBirth());

		System.out.println("    메일 : " + email);
	}

	@Override
	public boolean checkName(String name) {
		return getName().equals(name);
	}

}
