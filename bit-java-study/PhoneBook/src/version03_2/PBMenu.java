package version03_2;

public class PBMenu {
	static void mainMenu() {
		System.out.println("======================");
		System.out.println("<   전화 번호 관리 프로그램     >");
		System.out.println("----------------------");
		System.out.println("1. 정보 입력          2. 정보 검색");
		System.out.println("3. 정보 삭제          4. 전체 정보");
		System.out.println("5. 폰북 종료");
		System.out.println("======================");
		System.out.print("원하시는 메뉴의 번호를 입력하세요 \n==> ");
	}
	static void saveMenu() {
		System.out.println(" =============");
		System.out.println("<   정보 저장       >");
		System.out.println(" -------------");
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
