package Cp12_0428;

public class Ex1 {
	
	public static void main(String[] args) {

		int num1 = 0;
		int num2 = 2;
		try {
			int num3 = num1/num2;
			System.out.println(num3);
			System.out.println("나눗셈 결과의 몫: " + num2/num1);
			System.out.println("나눗셈 결과의 나머지: " + (num1 % num2));
		} catch (ArithmeticException e) {
			System.out.println("0으로 안나눠짐");
			System.out.println(e.getMessage());
			//.getMessage = String 값으로 반환
			e.printStackTrace();//오류사항 메세지로 보여줌
			return;// return 이어도 finally 는 실행된다
		}finally { // try에서 붙으면 무조건 실행되는 블럭
			System.out.println("무조건이야!!");
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
