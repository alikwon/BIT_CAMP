package ver02;

import java.util.*;
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

public class PhoneInfor {
	
	//private로 데이터 보호
	private String name;		// 이름
	private String phoneNumber;	// 번호
	private String birthday;	// 생일
	
	//초기화를 위한 생성자
	PhoneInfor(String name, String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//생년월일 없는 생성자
	PhoneInfor(String name, String phoneNumber){
		//this.name = name;
		//this.phoneNumber = phoneNumber;
		//this.birthday = null;
		
		//this이용 다른생성자 호출	  null문제해결
		this(name,phoneNumber,"(이름없음)");// null); //>> null의 정보를 바꿔줌
	}
	
	void showData() {	// 데이터 출력
		System.out.println("이름 : "+this.name);
		System.out.println("번호 : "+this.phoneNumber);
		System.out.println("생일 : "+this.birthday);
	}
	
	
	
		
}
