package cp4_0413;

public class WhileBreak {

	public static void main(String[] args) {

		int i = 0;
		int sum = 0;

		// 무한반복
		while (true) {

			if (sum > 100) {
				break; // break의 위치도 중요함!
			}
			// System.out.println(0);
			i++;
			sum += i;

		}
		System.out.println("마지막 값 : " + i);
		System.out.println("합이 100이 넘어간 값 : " + sum);
	}

}
