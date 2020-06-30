package cp4_0413;

public class ByTimes1 {

	public static void main(String[] args) {
		// for 중첩 사용 구구단
		// 단 x 1 ~9 = 결과
		// 하나하나 순차적으로 코딩
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "단");
			System.out.println("===============");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " x " + j + " = " + i * j);
			}
			System.out.println("===============");
		}

	}

}
