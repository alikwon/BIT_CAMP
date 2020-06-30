package cp3_0410;

public class CmpOp {

	public static void main(String[] args) {
		//변수 선언
		int A=10, B=20;
		
		if(true){
			System.out.println("참 입니다!");		// true일 때 출력
		} else {
			System.out.println("거짓 입니다!");		// false일 때 출력
		}
		if (A > B) {			
			System.out.println("A가 더 크다!");		// A > B = false
		} else {
			System.out.println("A가 더 크지 않다!");
		}
		if (A != B) {
			System.out.println("A와 B는 다르다!");	// A != B = true
		} else {
			System.out.println("A와 B는 같다!");
		}

	}

}
