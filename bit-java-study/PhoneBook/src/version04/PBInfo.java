package version04;

public class PBInfo {
	private String name;
	private String phoneNum;
	private String birth;
	private int infoNumber = PBManager.count + 1; // 생성 할때 마다 고유번호 매겨주기

	PBInfo(String name, String phoneNum, String birth) {

		this.name = name;
		this.phoneNum = phoneNum;
		this.birth = birth;

	}

	PBInfo(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;

	}

	void showData() {
		System.out.print("  이름 : " + name);
		System.out.print(", 번호 : " + phoneNum);
		System.out.println(", 생일: " + birth); 
	}
	
	void showBasicData() {
		System.out.print("  이름 : " + name);
		System.out.print(", 번호 : " + phoneNum);
		System.out.println(", 생일: " + birth); 
	}

	boolean checkName(String name) {
		return this.name.equals(name);
	}

	public int getInfoNumber() {
		return infoNumber;
	}

	public void setInfoNumber() {
		this.infoNumber -= 1;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	

//	boolean checkInfoNum(int number) {
//		return this.infoNumber==number; 
//	}

}
