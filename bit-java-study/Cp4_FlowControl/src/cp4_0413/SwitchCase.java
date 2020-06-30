package cp4_0413;

public class SwitchCase {

	public static void main(String[] args) {
		int menuNum = 1;

		switch (menuNum) {
		case 1:
			System.out.println("1. Simple Java");		
			//break를 생략해서 아래까지 다 실행됨
		
		case 2:
			System.out.println("2. Funny Java");
		
		case 3:
			System.out.println("3. Fantastic Java");
		
		default:	// 1,2,3 제외한나머지 => 수치를 적어주지 않음
			System.out.println("d. The best programming language");
		}
		System.out.println("Do you like coffee?");

	}

}
