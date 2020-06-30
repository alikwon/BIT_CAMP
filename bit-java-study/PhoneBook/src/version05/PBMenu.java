package version05;

public class PBMenu {
	static void mainMenu() {
		System.out.println("======================");
		System.out.println("<   전화 번호 관리 프로그램     >");
		System.out.println("----------------------");
		System.out.println(SelectMenuNum.SAVE+". 정보 저장          "
							+SelectMenuNum.SEARCH+". 정보 검색");
		System.out.println(SelectMenuNum.DELETE+". 정보 삭제          "
							+SelectMenuNum.SHOW_ALL+". 전체 정보");
		System.out.println(SelectMenuNum.EDIT+". 정보 수정          "
							+SelectMenuNum.EXIT+". 폰북 종료");
		System.out.println("======================");
		System.out.print("원하시는 메뉴의 번호를 입력하세요 \n==> ");
	}

	static void saveMenu() {
		System.out.println(" =============");
		System.out.println("<   정보 저장       >");
		System.out.println(" -------------");
		System.out.println("● 먼저 골라주세요");
	}

	static void searchMenu() {
		System.out.println(" =============");
		System.out.println("<   정보 검색       >");
		System.out.println(" -------------");
	}

	static void deleteMenu() {
		System.out.println(" =============");
		System.out.println("<   정보 삭제       >");
		System.out.println(" -------------");
	}
	
	static void editMenu() {
		System.out.println(" =============");
		System.out.println("<   정보 수정       >");
		System.out.println(" -------------");
		System.out.println("● 먼저 골라주세요");
	}

	static void showAllMenu() {

		System.out.println(" =============");
		System.out.println("<   전체 정보      >");
		System.out.println(" -------------");

	}

	static void endMenu() {
		System.out.println("===================");
		System.out.println("<< 프로그램을 종료합니다 >>");
		System.out.println("===================");
	}
}
