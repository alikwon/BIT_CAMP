package cp3_exs;

public class OperatorEx13 {

	public static void main(String[] args) {
		char c1 = 'a';			// 'a'의 유니코드 값 저장 = 97
		char c2 = c1;			// c1을 c2에 대입
		char c3 = ' ';			// c3 초기화 (공백사용)
		
		int i = c1 + 1; 		// 'a' + 1 >> 97 + 1
		
		c3 = (char) (c1 + 1);	// (int + int)를 char로 형변환 
		c2++;					//증감연산자의 경우 char의 형을 유지함
		c2++;
		
		System.out.println("i=" + i);	// 98이 출력
		System.out.println("c2=" + c2);	// 유니코드 99 문자 = 'c'
		System.out.println("c3=" + c3); // 유니코드 98 문자 = 'b'

	}

}
