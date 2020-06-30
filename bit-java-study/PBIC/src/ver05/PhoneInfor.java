package ver05;

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

public abstract class PhoneInfor implements Info{
	
	//private로 데이터 보호
	private String name;		// 이름
	private String phoneNumber;	// 번호
	private String addr;
	private String email;// 생일
	
	//초기화를 위한 생성자
	PhoneInfor(String name, String phoneNumber, String addr, String email){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}

	//2020.4.29
	//수정내용: interface구현으로 메서드 오버라이딩 생략
	//		 phoneinfo클래스 ==> 추상클래스
	public abstract void showAllInfo();
//	void showAllData() {
//		System.out.println("이름 : "+name);
//		System.out.println("번호 : "+phoneNumber);
//		System.out.println("주소 : "+email);
//		System.out.println("이메일 : "+email);
//	}	//상속후 오버라이딩
	
	void showBasicInfo() {
		System.out.println("이름 : "+name);
		System.out.println("번호 : "+phoneNumber);
		System.out.println("주소 : "+email);
		System.out.println("이메일 : "+email);
	}
	
	//(findData 에서 넘어옴) >>>name 속성값과 전달받은 문자열을 비교해서 반환해주는 메서드
	boolean checkName(String name) {
		return this.name.equals(name); 
	}

	public String getName() {
		return name;
	}
	
	
	
		
}
