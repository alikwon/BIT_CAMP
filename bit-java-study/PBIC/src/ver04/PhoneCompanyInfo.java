package ver04;

public class PhoneCompanyInfo extends PhoneInfor {

	private String company;
	private String dept;
	private String job;
	
	PhoneCompanyInfo(String name, 
			  				String phoneNumber, 
			  				String addr,
			  				String email, 
			  				String company, 
			  				String dept,
			  				String job) {
		super(name, phoneNumber, addr, email);
		this.company=company;
		this.dept=dept;
		this.job=job;
		// TODO Auto-generated constructor stub
	}

	@Override
	void showAllData() {
		// TODO Auto-generated method stub
		super.showAllData();
		System.out.println("회사 : "+company);
		System.out.println("부서 : "+dept);
		System.out.println("직무 : "+job);
	}
	
}

