package version05;

public abstract class PBInfo implements Info_Interface{
// interface를 구현하는 추상클래스
	
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
	
	//인터페이스에 public abstract가 생략 되어있으므로 
	//인터페이스를 구현하는 폰북info클래스의 메서드도 public이 되어야함
	
	// interface 구현
	public void showAllData() {
		System.out.print(" 이름 : " + name);
		System.out.print(", 번호 : " + phoneNum);
		System.out.println(", 생일: " + birth); 
	}
	
	// interface 구현하지 않고 추상메서드
	public abstract void showBasicData();
	//추상 메서드
	public abstract boolean checkName(String name);

	int getInfoNumber() {
		return infoNumber;
	}

	void setInfoNumber() {
		this.infoNumber -= 1;
	}

	void setBirth(String birth) {
		this.birth = birth;
	}

	String getName() {
		return name;
	}

	String getPhoneNum() {
		return phoneNum;
	}

	String getBirth() {
		return birth;
	}
	
}

//	boolean checkInfoNum(int number) {
//		return this.infoNumber==number; 
//	}

