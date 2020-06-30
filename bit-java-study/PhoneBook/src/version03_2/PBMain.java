package version03_2;


public class PBMain {
	public static void main(String[] args) {

		PBManager manager = new PBManager();

		while (true) {
			PBMenu.mainMenu();

			int select = PBManager.input.nextInt();
			PBManager.input.nextLine();
			
			switch(select) {
			case 1:
				PBMenu.saveMenu();
				manager.saveData();
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
			default:
				System.out.println("※ 메뉴의 번호만 입력해야 합니다 ※");
				break;
			}

		}
		// 메인메뉴선택화면을 manager로 바꿔도 될 듯

	}

}