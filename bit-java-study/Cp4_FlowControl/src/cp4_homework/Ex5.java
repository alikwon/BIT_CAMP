package cp4_homework;

public class Ex5 {

	public static void main(String[] args) {
//		num < 0 이라면 “0 미만” 출력
//		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
//		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
//		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
//		300 ≤ num 이라면 “300이상 “ 출력
		
		int num = 300;
		
		switch (num/100) {
			
			case 0:
				System.out.println("0 이상 100미만");
				break;
			case 1:
				System.out.println("100 이상 200미만");
				break;
			case 2:
				System.out.println("200 이상 300미만");
				break;
			default:
				if (num<0) {
					System.out.println("0 미만");
					break;
					}
				System.out.println("300이상");
		}

	}

}
