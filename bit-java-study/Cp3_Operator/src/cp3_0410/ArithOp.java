package cp3_0410;

public class ArithOp {

	public static void main(String[] args) {
		
		//정수타입 숫자 두개를 받음 ==> 변수 선언
		int num1;
		int num2;
		num1 = 10;
		num2 = 3;
		
		//덧셈 연산 후 결과 출력
		int result = num1 + num2; //산술 --> 대입
		System.out.println("num1 + num2 = "+ result);
		
		//뺄셈 연산 후 결과 출력
		result = num1 - num2;
		System.out.println("num1 - num2 = "+ result);
		
		//곱셈 연산 후 결과 출력
		result = num1 * num2;
		System.out.println("num1 * num2 = "+ result);
		
		//나눗셈 연산 후 결과 출력
		result = num1 / num2;
		System.out.println("num1 / num2 = "+ result);
		
		//나눈 뒤 나머지 결과 출력
		result = num1 % num2;
		System.out.println("num1 % num2 = "+ result);
		
	}

}
