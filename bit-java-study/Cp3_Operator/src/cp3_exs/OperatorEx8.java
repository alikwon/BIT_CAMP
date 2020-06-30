package cp3_exs;

public class OperatorEx8 {

	public static void main(String[] args) {
		byte a = 10;			
		byte b = 20;
		byte c = (byte)(a+b);	//byte c = a + b;  ==> 형변환 에러
		System.out.println(c);	//30
	}

}
