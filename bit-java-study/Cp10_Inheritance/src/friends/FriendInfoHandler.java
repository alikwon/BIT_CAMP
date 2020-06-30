package friends;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {
	
	// 20.04.28
	// 싱글톤 처리
	// ★★★ 1번을 공식처럼 생각할 것
	// 1.manager 클래스의 싱글톤 패턴
	// 	생성자 접근제어지시자 : private → 인스턴스 생성을 막는다
	// 	공동으로 사용할 인스턴스를 생성 : static private
	// 	참조변수를 반환하는 메서드 필요 : static public 외부에서 접근할수있도록
	// 2.interface 기반의 상수,메뉴 표현
	// 3.interface ⇒ 추상클래스 ⇒ 상속관계구조
	
	// 싱글톤 : 공동으로 사용할 인스턴스! 내부에서 인스턴스 생성
	private static FriendInfoHandler handler = new FriendInfoHandler(100);
	
	// 외부에서 참조할수 있도록 매서드
	public static FriendInfoHandler getInstance() {
		return handler;
	}
	// Friend타입의 정보를 저장할 배열을 만든다
	// 친구정보 저장
	// 친구정보의 기본정보 출력
	// 친구정보의 상세정보 출력
	
//	private Friend[] myFriends; // Friend타입의 배열선언
	private ArrayList<Friend> myFriends; //ArrayList
//	private int numOfFriend; // 저장된 친구의 정보개수//리스트 사용시 필요가없음
	Scanner sc;

	// 초기화
	// 저장공간의 사이즈를 받아서 배열생성
	
	// 싱글톤 : 생성자를 private처리
	private FriendInfoHandler(int num) {
//		myFriends = new Friend[num];
//		numOfFriend = 0;
		
		//ArrayList 인스턴스 생성
		myFriends = new ArrayList <Friend>();
		sc = new Scanner(System.in);
	}

	// 친구정보 저장
	// 1. 배열에 저장기능
	// 2. 사용자에게 데이터를 받아 요청에 맞는 인스턴스 생성

	// 1
	private void addFriendInfo(Friend f) {

		// 배열에 저장
//		myFriends[numOfFriend] = f;
//		numOfFriend++;
		
		//리스트에 저장
		myFriends.add(f);
	}

	// 2 : 1-high/2-univ 분기
	void creatFriend(int choice) {
		// 기본정보 받기
		System.out.println("이름 입력");
		String name = sc.nextLine();
		System.out.println("전번 입력");
		String phoneNum = sc.nextLine();
		System.out.println("주소 입력");
		String address = sc.nextLine();
		System.out.println("메일 입력");
		String eMail = sc.nextLine();

		Friend friend = null;
		// 1일때 정보 받기
		if (choice == 1) {
			System.out.println("직업 입력");
			String work = sc.nextLine();
			// high 인스턴스 생성

			friend = new HighFriend(name, 
									phoneNum, 
									address, 
									eMail, 
									work);
			// addFriendInfo 호출
			addFriendInfo(friend);
		} else {
			// 2일때 정보 받기
			System.out.println("전공 입력");
			String major = sc.nextLine();
			System.out.println("학년 입력");
			String grade = sc.nextLine();

			friend = new UnivFriend(name, 
									phoneNum, 
									address, 
									eMail, 
									major, 
									Integer.parseInt(grade));

			// univ 인스턴스 생성

			// addFriendInfo 호출
			addFriendInfo(friend);
		}

	}
	
	void showAllSimpleData() {
		System.out.println("===친구의 기본정보 출력합니다===");
//		for (int i=0;i<numOfFriend;i++) {
//			myFriends[i].showBasicInfo();
		for (int i=0;i<myFriends.size();i++) {
			myFriends.get(i).showBasicInfo();
		}
	}
	
	void showAllData() {
		System.out.println("===친구의 상세정보를 출력합니다===");
//		for (int i=0;i<numOfFriend;i++) {
//			myFriends[i].showData(); //오버라이딩된 매서드
		
		for (int i =0; i< myFriends.size();i++) {
			myFriends.get(i).showData();
		}
	}
	
	
	
	
}
