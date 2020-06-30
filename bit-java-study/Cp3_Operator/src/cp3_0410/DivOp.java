package cp3_0410;

public class DivOp {
	
	public static void main(String[] args) {
		
		//변수 선언 및 초기화
		int num1 = 7;
		int num2 = 3;
		
		//정수의 나누기 연산
		System.out.println("num1 / num2 = "+ num1/num2);
		
		//실수의 나누기 연산
		System.out.println("num1 / num2 = "+ 7f/3);				//3은 자동 형변환
		
		//실수의 나누기 연산 ==> 형변환 연산자 먼저..(단항)
		System.out.println("num1 / num2 = "+ (float)num1/num2);	//num2는 자동 형변환
		
	}

}
