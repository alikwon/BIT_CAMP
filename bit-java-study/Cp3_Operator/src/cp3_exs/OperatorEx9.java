package cp3_exs;

public class OperatorEx9 {

	public static void main(String[] args) {
		byte a = 10;			//변수 선언
		byte b = 30;
		byte c = (byte)(a * b);	//(byte)(int*int)
		System.out.println(c);	// byte의 표현 범위를 넘어서 300이 아니라 44가 출력

	}

}
