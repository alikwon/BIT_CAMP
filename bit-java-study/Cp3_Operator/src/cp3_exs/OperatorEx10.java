package cp3_exs;

public class OperatorEx10 {

	public static void main(String[] args) {
		int a = 1000000;		// 변수선언 a=1백만
		int b = 2000000;		// b=2백만
		long c = a * b;			// 형변환이 안됐음
								// 수정 : long c = (long)a*b; 
		System.out.println(c);	// 2조가 아니라 왜곡된값 출력

	}

}
