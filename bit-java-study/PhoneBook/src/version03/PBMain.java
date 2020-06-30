package version03;


public class PBMain {
	public static void main(String[] args) {

		PBManager manager = new PBManager();

		while (true) {
			PBMenu.showMenu();

			String select = PBManager.input.nextLine();
			
			if (select.equals("1")) {
				PBMenu.showSave();
				manager.saveData();
			}
			else if (select.equals("2")) {
				PBMenu.showSearch();
				manager.searchData();
			}

			else if (select.equals("3")) {
				PBMenu.showDelete();
				manager.delData();
			}
			else if (select.equals("4")) {
				System.out.println("<<< 전체 정보 >>>");
				manager.showAll();
			}
			else if (select.equals("5")) {
				PBMenu.showEnd();
				// return; //메인메서드가 종료
				System.exit(0);// 가상머신에서 프로세스 종료
			}
			else {
				System.out.println("※ 메뉴의 번호만 입력해야 합니다 ※");
			}

		}
		// 메인메뉴선택화면을 manager로 바꿔도 될 듯

	}

}