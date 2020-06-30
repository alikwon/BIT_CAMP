package ver06;

public class PhoneCompanyInfo extends PhoneInfo {

	private String company;
	private String dept;
	private String job;
	
	public PhoneCompanyInfo(String name, 
							String pNumber, 
							String addr, 
							String email) {
		super(name, pNumber, addr, email);
	}


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
	}


	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}

