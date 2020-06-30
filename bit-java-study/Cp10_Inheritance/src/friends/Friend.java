package friends;

/*
	친구의 정보를 저장하기 위한 클래스
	상속목적의 상위클래스로 정의
	기본 속성과 기능을 구성한다
	
 */
public class Friend implements Info{

	private String name;	//친구 이름
	private String phoneNum;// 친구 전번
	private String address;	//친구 주소
	private String eMail;	//친구 메일

	Friend(String name, String phoneNum, String address, String eMail) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.eMail = eMail;
	}
	
	//기본정보 4가지 출력
	void showBasicInfo() {
		System.out.println("이름 : "+this.name);
		System.out.println("전번 : "+this.phoneNum);
		System.out.println("생일 : "+this.address);
		System.out.println("메일 : "+this.eMail);
	}
	// 상속목적으로 오버라이딩할 메서드
	// 기본데이터와 하위 클래스 데이터를 출력하도록 오버라이딩 하자.
//	void showData() {
//		
//	}
	public void showData() {}
	// 추상 메서드 생성
	// 매서드의 성격을 정의해서 하위클래스 작성에 도움을 줌
//	abstract void showData();

}


