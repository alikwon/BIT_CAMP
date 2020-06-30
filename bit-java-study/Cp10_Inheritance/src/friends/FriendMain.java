package friends;

public class FriendMain {

	public static void main(String[] args) {
//		FriendInfoHandler handler = new FriendInfoHandler(10);
		FriendInfoHandler handler = FriendInfoHandler.getInstance();
		
		while(true) {
			System.out.println("===메뉴 선택===");
			System.out.println(Menu.INSERT_HIGH+". 고교친구저장");
			System.out.println(Menu.INSERT_UNIV+". 대학친구저장");
			System.out.println(Menu.PRINT_BASIC+". 친구기본정보");
			System.out.println(Menu.PRINT_ALL+". 친구상세정보");
			System.out.println(Menu.EXIT+". 프로그램종료");
			System.out.println("============");
			int choice=0;
			
			try {
				choice = handler.sc.nextInt();
				handler.sc.nextLine();
			}catch(Exception e) { //InputMismatch Exception 인스턴스 전달
				System.out.println("메뉴입력다시해주세요");
				handler.sc.nextLine();
				continue;
			}
		
			
			switch(choice) {
			case Menu.INSERT_HIGH: case Menu.INSERT_UNIV: 
				handler.creatFriend(choice);
				break;
			case Menu.PRINT_BASIC:
				handler.showAllSimpleData();
				break;
			case Menu.PRINT_ALL:
				handler.showAllData();
				break;
			case Menu.EXIT:
				System.out.println("==종료합니다==");
				System.exit(0);
				break;
			default:
				System.out.println("해당번호만 입력해주세요");
			}
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}
