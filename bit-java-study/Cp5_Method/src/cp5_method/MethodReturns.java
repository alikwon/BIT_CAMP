package cp5_method;

public class MethodReturns {
	public static void main(String[] args) {
		int result = adder(4, 5);
		System.out.println("4와 5의 합: " + result);
		System.out.println("3.5의 제곱: " + square(3.5));
	}

	public static int adder(int num1, int num2) { //타입이 일치해야함
		int addResult = num1 + num2;
		return addResult; //결과 값을 반환해준다
	}

	public static double square(double num) {
		return num * num;
	}
}
