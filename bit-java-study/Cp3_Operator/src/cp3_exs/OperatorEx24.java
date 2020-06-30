package cp3_exs;

public class OperatorEx24 {

	public static void main(String[] args) {
		char x = 'j';	
		
		//알파벳인지 판별하는 조건
		//'a' <= 'j' <= 'z' || 'A' <= 'j' <= 'Z'
		//  알파벳 소문자 이거나		  알파벳 대문자 이거나
		if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
			System.out.println("유효한 문자입니다.");
		} else {
			System.out.println("유효하지 않은 문자입니다.");
		}

	}

}
