package version04;

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
	void showData() {
		super.showData();
		System.out.print("    메일 : "+email);
		System.out.println(", 직장 : "+company);
	}

	@Override
	void showBasicData() {
		super.showBasicData();
		System.out.print("    메일 : "+email);
	}
	
	
}
