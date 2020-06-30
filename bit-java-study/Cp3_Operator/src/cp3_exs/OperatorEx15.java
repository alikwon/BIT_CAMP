package cp3_exs;

public class OperatorEx15 {

	public static void main(String[] args) {
		char c = 'a';		
		for (int i = 0; i < 26; i++) {	// 지역변수 i, for안의 문장을 26번 반복
			System.out.print(c++); 		// 'a'부터 26개의 문자를 출력 >> 소문자 알파벳
		}
		System.out.println();			// 줄 바꿈
		
		c = 'A';		//변수 재할당
		for (int i = 0; i < 26; i++) {	// for안의 문장을 26번을 반복
			System.out.print(c++); 		// 'A'부터 26개의 문자를 출력 >> 대문자 알파벳
		}
		System.out.println();
		
		c = '0';		//변수 재할당
		for (int i = 0; i < 10; i++) {	// 블럭{} 안의 문장을 10번을 반복한다.
			System.out.print(c++); 		// '0'부터 10개의 문자를 출력한다. >> 0부터 9
		}
		System.out.println();

	}

}
