package cp4_0413;

public class ContinueBasic {

	public static void main(String[] args) {
		int num = 0;
		int count = 0;

		while ((num++) < 100) {
			if (num % 5 != 0 || num % 7 != 0)
				// num % 35 != 0 과 같은 말
				continue;
			count++;
			// 35의 배수일 때 실행됨
			System.out.println(num);// 35의 배수 출력
		}
		System.out.println("count: " + count);
		// 100까지 35의 배수의 개수출력

	}

}
