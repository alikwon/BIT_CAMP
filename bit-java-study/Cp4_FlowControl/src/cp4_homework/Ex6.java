package cp4_homework;

public class Ex6 {

	public static void main(String[] args) {
		// while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성

		int num = 1;
		int sum = 0;

		while (num < 10) {
			sum += num;
			num++;
		}
		System.out.println(sum);
	}

}
