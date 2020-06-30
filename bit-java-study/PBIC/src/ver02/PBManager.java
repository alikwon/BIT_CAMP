package ver02;

import java.util.Scanner;

/*
	전화번호 정보를 저장하는 기능만을 포함하는 클래스
	
	1) 사용자에게 입력받음
	2) 인스턴스 생성 후 반환
*/

public class PBManager {
	Scanner sc = new Scanner(System.in);
	 
	PhoneInfor createInstance() {// 인스턴스 생성 매서드
		//return new PhoneInfor() 두가지 경우(생일)가 있기때문에 적절하지 못함
		PhoneInfor info = null;
		
		System.out.println("정보저장을 위한 데이터를 입력합니다");
		System.out.println("이름을 입력해주세요 >>");
		String name = sc.nextLine();// nextLine은 한 줄 끝까지
		
		System.out.println("번호를 입력해주세요 >>");
		String phoneNumber = sc.nextLine();
		
		System.out.println("생일을 입력해주세요 >>");
		String birthday = sc.nextLine();
		
		//사용자의 입력데이터에 따라 인스턴스 생성 구분
		// birth가 null이거나 공백 제거 후 비어있다면
		if(birthday ==null || birthday.trim().isEmpty()) { //trim() = 공백제거
			info = new PhoneInfor(name, phoneNumber);
		}else {
			info = new PhoneInfor(name, phoneNumber, birthday);
		}
		
		return info;	//info객체 반환

	}

}