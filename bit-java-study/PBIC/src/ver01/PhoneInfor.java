package ver01;

import java.util.*;
/*	Version 0.1 전화번호 관리 프로그램. 
	
	PhoneInfor 라는 이름의 클래스를 정의해 보자. 
	클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 
	저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	
	• 이름            name              String
	• 전화번호       phoneNumber     String
	• 생년월일       birthday            String 
	
	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
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
