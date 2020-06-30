package ver06;

/*	
 	Project : ver 0.20
	"프로그램 사용자로부터 데이터 입력"
	프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
	핵심.
	단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
	프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
	
	키보드로부터 데이터 입력 
	↓
	입력 받은 데이터로 인스턴스 생성
	↓
	생성된 인스턴스의 메소드 호출
	
	1) 사용자에게 입력받음
	2) 인스턴스 생성
*/

public abstract class PhoneInfo {
	
	//private로 데이터 보호
	private int idx;
	
	private String name;		// 이름
	private String pNumber;	// 번호
	private String addr;
	private String email;
	
	public PhoneInfo() {
	}

	//초기화를 위한 생성자
	PhoneInfo(String name, String pNumber, String addr, String email){
		this.name = name;
		this.pNumber = pNumber;
		this.addr = addr;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return null;
	}
	
	public int getYear() {
		return 0;
	}
	
	public String getNickName() {
		return null;
	}
	
	public String getCafeName() {
		return null;
	}
	
	public String getCompany() {
		return null;
	}
	
	public String getDept() {
		return null;
	}
	
	public String getJob() {
		return null;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

		
}
