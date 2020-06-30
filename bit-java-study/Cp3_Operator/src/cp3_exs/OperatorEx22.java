package cp3_exs;

public class OperatorEx22 {

	public static void main(String[] args) {
		
		if (10 == 10.0f) {
			System.out.println("10과 10.0f는 같다.");}
		
		if ('0' != 0) {		//유니코드 0 = 48
			System.out.println("'0'과 0은 같지 않다.");}

		if ('A' == 65) {	// 유니코드 A = 65
			System.out.println("\"A\"는 65와 같다.");} // \" = 쌍따옴표 출력
		
		int num = 5;		//변수 선언
		if (num > 0 && num < 9) {	// 0 < num < 9
			System.out.println("5는 0보다 크고, 9보다는 작다.");}
	}

}
