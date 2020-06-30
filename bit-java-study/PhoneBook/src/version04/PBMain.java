package version04;



public class PBMain {
	public static void main(String[] args) {

		int select = 0; // 유저 입력값
		PBManager manager = new PBManager();
		while (true) {
			PBMenu.mainMenu();

			select = PBManager.input.nextInt();

			PBManager.input.nextLine();
			// 숫자가 아닌 문자입력시 에러
			switch (select) {
			case 1:
				if (PBManager.count == 100) { // 저장된 번호가 100개가 됐을때
					System.out.println("★ 목록이 꽉 찼어요 ★");
					break;
				}
				PBMenu.saveMenu();
				manager.createInstance();
				manager.goToMain();
				break;
			case 2:
				PBMenu.searchMenu();
				manager.searchData();
				manager.goToMain();
				break;
			case 3:
				PBMenu.deleteMenu();
				manager.delData();
				manager.goToMain();
				break;
			case 4:
				PBMenu.showAllMenu();
				manager.showAll();
				manager.goToMain();
				break;
			case 5:
				PBMenu.endMenu();
				// return; //메인메서드가 종료
				System.exit(0);// 가상머신에서 프로세스 종료
				break;
//			default:
//				System.out.println("※ 메뉴의 번호만 입력하세요 ※");
//				break;
			}

		}
		// 메인메뉴선택화면을 manager로 바꿔도 될 듯

	}

}