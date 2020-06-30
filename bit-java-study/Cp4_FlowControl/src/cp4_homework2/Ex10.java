package cp4_homework2;
//[10] int타입의 변수 num 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하라. (1)에 알맞은 코드를넣으시오.
//[주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.
//[연습문제]/ch4/Exercise4_10.java
//classExercise4_10 {
//	public static void main(String[] args) {
//		int num = 12345;
//		int sum = 0;
//		/*
//		(1) 알맞은 코드를 넣어 완성하시오.
//		*/
//		System.out.println("sum="+sum);
//		}
//}
// 
//[실행결과]
//15
public class Ex10 {

	public static void main(String[] args) {
		// 10 으로 나누면 1의 자리 숫자가 나머지
		int num = 12345;
		int sum = 0;
		while (num > 0) {
			sum = sum + (num % 10);
			num /= 10;
		}
		System.out.println("sum=" + sum);

	}

}
