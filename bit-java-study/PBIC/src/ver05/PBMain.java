package ver05;

import java.util.Scanner;

/*	
	static 메서드는 프로그램 끝날때 까지 유지 >> 자제
	static{}(초기화블럭) : 프로그램 시작시 한번
*/
public class PBMain {

	public static void main(String[] args) {

		PBManager manager = new PBManager(100);

		// PhoneInfor에 메서드까지 구성하면
		// info 객체가 만들어질때마다 메서드까지 생성됨
		// 객체 중심으로 생각하기
		// 반복문안에 변수 선언되면 불필요한 변수 생성반복됨

		while (true) {

//			info = manager.createInstance();
//			// System.out.println(manager.createInstance()); 주소값나옴
//			
//			manager.saveInfo(info);
//			
//			manager.showAll();
//			
//			manager.findData();
//			
//			manager.delData();
//			
//			manager.showAll();
//			for(int i=0; i<manager.cnt ; i++) { //범위를 cnt로 해줘야 null오류 안뜸
//				manager.pBooks[i].showData();
//			}

			
			while (true) {
				Menu.showMenu();

				int selectNum = PBManager.sc.nextInt();
				PBManager.sc.nextLine();
				switch (selectNum) {
				case 1: // 이 단계에서 creatInstance 를 saveInfo를 넣음,
						// saveInfo를 오버로딩해서 처리했음
//					PhoneInfor info = manager.createInstance();
//					manager.saveInfo(info);
					manager.createInstance(); // 오버로딩을 통해 위의 두줄을 간소화
					break;
				case 2:
					manager.findData();
					break;
				case 3:
					manager.delData();
					break;
				case 4:
					manager.showAll();
					break;
				case 5:
					manager.editInfo();
					break;
				case 6:
					// return; //메인메서드가 종료
					System.exit(0); // 가상머신에서 프로세스 종료

				}
				// 메인메뉴선택화면을 manager로 바꿔도 될 듯

			}

		}
	}

}
