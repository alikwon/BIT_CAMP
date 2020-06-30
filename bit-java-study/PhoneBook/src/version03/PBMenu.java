package version03;

public class PBMenu {
	static void showMenu() {
		System.out.println("======================");
		System.out.println("<전화 번호 관리 시스템>");
		System.out.println("----------------------");
		System.out.println("1. 정보 입력");
		System.out.println("2. 정보 검색");
		System.out.println("3. 정보 삭제");
		System.out.println("4. 전체 정보");
		System.out.println("5. 폰북 종료");
		System.out.println("======================");
		System.out.print("원하시는 메뉴의 번호를 입력하세요 >>");
	}

	static void showSearch() {
		System.out.println("==============");
		System.out.println("<<< 정보 검색 >>>");
		System.out.println("--------------");
		System.out.print("검색하실 이름을 입력하세요>>");

	}

	static void showDelete() {
		System.out.println("==============");
		System.out.println("<<< 정보 삭제 >>>");
		System.out.println("--------------");
		System.out.print("검색하실 이름을 입력하세요>>");

	}

	static void showSave() {
		 
        System.out.println("==============");
        System.out.println("<<< 정보 저장 >>>");
        System.out.println("--------------");
        
	}
	
	static void showEnd() {
		System.out.println("===================");
		System.out.println("<< 프로그램을 종료합니다 >>");
		System.out.println("===================");
	}
}
