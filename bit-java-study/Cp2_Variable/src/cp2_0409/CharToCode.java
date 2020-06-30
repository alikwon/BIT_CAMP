

package cp2_0409;

public class CharToCode {

	public static void main(String[] args) {
		char ch = 'A'; //char를 변수선언 
		//char ch = '\u0041' 과 같다
		
		int code = (int)ch; 
		//명시적 형변환
		
		System.out.println(ch);
		System.out.println(code);//A를 출력하고 A의 유니코드 값 65를 출력

	}

}
