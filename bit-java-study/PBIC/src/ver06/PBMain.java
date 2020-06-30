package ver06;

import java.util.InputMismatchException;

public class PBMain {
	public static void main(String[] args) {
		int select=0; // 유저 입력값
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
//		PBManager manager = new PBManager();
		// getInstance메서드를 이용해서 생성된 객체를 받아옴
		PBManager pm = new PBManager();

		while (true) {

			PBMenu.mainMenu();

			try {
				select = Integer.parseInt(pm.sc.nextLine().trim());

				// 1~5가 아닌 숫자를 넣을 시 사용자 정의 예외 처리 해봤음
				if (select < 1 || select > 6) {
					MyException e = new MyException();
					throw e;
				}
			} catch (MyException e) {
				System.out.println("★ 메뉴의 번호는 6번까지 밖에 없어요 ★");
				// ★ 메뉴의 번호는 5번까지 밖에 없어요 ★ 출력됨
				continue;
			} catch (InputMismatchException e) {
				System.out.println("★ 잘못된 입력이에요");
				System.out.println("★ 메뉴의 번호만 입력하세요 ★");
				System.out.println();
				continue;
			} catch (NumberFormatException e) {
				System.out.println("★ 입력이 없어요!!");
				continue;
			} finally {// finally에 써줌으로써 좀더 안정적
//				PBManager.input.nextLine();
			}

//			PBManager.input.nextLine();
			// initerface기반의 상수 표현을 바탕으로 메뉴 선택
			switch (select) {
			case SelectMenuNum.SAVE:
				PBMenu.saveMenu();
				pm.insertInfo();
				break;
			case SelectMenuNum.SEARCH:
				PBMenu.searchMenu();
				pm.searchInfo();
				break;
			case SelectMenuNum.DELETE:
				PBMenu.deleteMenu();
				pm.deleteInfo();
				break;
			case SelectMenuNum.EDIT:
				PBMenu.editMenu();
				break;
			case SelectMenuNum.SHOW_ALL:
				PBMenu.showAllMenu();
				pm.showInfo();
				break;
			case SelectMenuNum.EXIT:
				PBMenu.endMenu();
				// return; //메인메서드가 종료
				System.exit(0);// 가상머신에서 프로세스 종료
				break;
			default:
				System.out.println("★ 메뉴의 번호만 입력하세요 ★");
				break;
			}

		}
		// 메인메뉴선택화면을 manager로 바꿔도 될 듯

	}

}