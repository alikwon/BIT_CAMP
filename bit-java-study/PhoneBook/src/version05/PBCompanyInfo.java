package version05;

public class PBCompanyInfo extends PBInfo {

	private String email;
	private String company;

	PBCompanyInfo(String name, String phoneNum, String birth, String email, String company) {
		super(name, phoneNum, birth);

		this.email = email;
		this.company = company;

	}

	PBCompanyInfo(String name, String phoneNum, String email, String company) {
		super(name, phoneNum);
		this.email = email;
		this.company = company;
	}

	@Override
	public void showAllData() {
		super.showAllData();
		System.out.print("	메일 : "+email);
		System.out.println(", 직장 : "+company);
	}

	@Override
	public void showBasicData() {
		System.out.print(" 이름 : " + getName());
		System.out.print(", 번호 : " + getPhoneNum());
		System.out.print(", 생일: " + getBirth());
		System.out.println("    메일 : "+email);
	}
	
	@Override
	public boolean checkName(String name) {
		return getName().equals(name);
	}
}
