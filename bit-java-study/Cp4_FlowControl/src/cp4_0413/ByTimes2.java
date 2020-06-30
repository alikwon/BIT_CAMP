package cp4_0413;

public class ByTimes2 {

	public static void main(String[] args) {
		// while 중첩 사용 구구단
		// 단 x 1 ~9 = 결과
		// 천천히 순차적으로 코딩
		int i = 2;
		while (i < 10) {
			System.out.println(i + "단");
			System.out.println("===============");
			int j = 1; // while 안에 선언
			while (j < 10) {
				System.out.println(i + " x " + j + " = " + i * j);
				j++;
			}
			System.out.println("===============");
			i++;

		}
	}

}
