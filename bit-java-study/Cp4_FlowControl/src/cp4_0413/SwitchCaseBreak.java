package cp4_0413;

public class SwitchCaseBreak {

	public static void main(String[] args) {
		int menuNum = 2;

		switch (menuNum) {
		case 1:
			System.out.println("1. Simple Java");		
			break;	//break가 속해 있는 블럭{} 을 벗어 나는 것
			
		case 2:
			System.out.println("2. Funny Java");
			break;
		
		case 3:
			System.out.println("3. Fantastic Java");
			break;
			
		default:	// case 1,2,3 제외한나머지
			System.out.println("d. The best programming language");
		}
		System.out.println("Do you like coffee?");

	}

}
