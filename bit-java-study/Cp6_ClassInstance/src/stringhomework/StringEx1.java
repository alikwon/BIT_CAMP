package stringhomework;

/*
	 문제 1. 다음 형태로 String 인스턴스를 생성.
	
	String str = “ABCDEFGHIJKLMN”;
	 
	그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.
	
	문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
	String str = “990929-1010123”
	 
	 
	이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.
*/
public class StringEx1 {
	
	// 내가 쓴 답안
//	public static void main(String[] args) {
//		String str = "ABCDEFGHIJKLMN";
//		if (str.equals("ABCDEFGHIJKLMN")) 
//			System.out.println(true);
//		StringBuffer str2= new StringBuffer(str);
//		System.out.println(str2.reverse());
//	}
//}
	
	public static void main(String[] args) {
		String str = "ABCDEFGHIJKLMN";
		int numOfStr = str.length(); // str 문자열길이를 numOfStr에 반환.
		
		/* 역순 String Class 사용 */
		for (int i = numOfStr - 1; i >= 0; i--) {
			char a = str.charAt(i);
			System.out.print(a + " ");
		}
		System.out.println("\n=========");
		
		/* 역순 StringBuffer Class 사용 */
		StringBuffer strB = new StringBuffer("ABCDEFGHIJKLMN");
		System.out.println(strB.reverse());
	}
}