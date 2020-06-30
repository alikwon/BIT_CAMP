package cp3_exs;

public class OperatorEx11 {

	public static void main(String[] args) {
		long a = 1000000 * 1000000;	// int * int = int 왜곡
		long b = 1000000 * 1000000L;// int * long = long
		
		System.out.println(a);		//왜곡된 값이 출력
		System.out.println(b);		//100만 * 100만 = 1조 출력

	}

}
