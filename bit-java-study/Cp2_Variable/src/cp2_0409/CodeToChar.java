package cp2_0409;

public class CodeToChar {

	public static void main(String[] args) {
		int code = 65;  // int 형으로 변수 선언
		char ch = (char)code; //명시적 형변환 = 유니코드 65의 문자
		
		System.out.println(code);
		System.out.println(ch); //정수 65가 출력되고 유니코드 65의 문자A가 출력

	}

}
