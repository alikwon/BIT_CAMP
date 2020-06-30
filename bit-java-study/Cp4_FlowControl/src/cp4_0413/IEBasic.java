package cp4_0413;

public class IEBasic {

	public static void main(String[] args) {

		if (true) {
			System.out.println("true일 때 출력");
		}
		if (false) {
			System.out.println("true일 때 출력");
		}
		if (false) { 	// 하나마나한 블럭(문법오류는 없지만 의미없음)
			System.out.println("true일 때 출력");
		} else { 		// false가 아닐때 출력
			System.out.println("false일 때 출력");
		}
		if (10 > 5) {
			System.out.println("10은 5보다 큼");
		}
		int num = 10;
		if (num == 5) {
			System.out.println("10은 5와 같다");

		}
	}

}
