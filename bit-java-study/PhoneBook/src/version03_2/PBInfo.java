package version03_2;

public class PBInfo {
	private String name;
	private String phoneNum;
	private String birth = "(입력없음)";
	private int infoNumber = PBManager.count + 1; // 생성 할때 마다 고유번호 매겨주기

	PBInfo(String name, String num, String birth) {

		this.name = name;
		this.phoneNum = num;
		this.birth = birth;

	}

	PBInfo(String name, String num) {
		this.name = name;
		this.phoneNum = num;

	}

	void showData() {
		System.out.println("  이름 : " + name + ", 번호 : " + phoneNum + ", 생일: " + birth);
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
	

//	boolean checkInfoNum(int number) {
//		return this.infoNumber==number; 
//	}

}
