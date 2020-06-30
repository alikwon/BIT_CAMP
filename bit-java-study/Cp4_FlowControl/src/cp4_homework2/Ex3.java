package cp4_homework2;

public class Ex3 {

	public static void main(String[] args) {
//		[3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를
//		계산하시오.

		int sum = 0;
		int sum1 = 0;

		for (int i = 1; i <= 10; i++) {
			sum += i;
			sum1 += sum;
		}
		System.out.println(sum1);

	}

}
