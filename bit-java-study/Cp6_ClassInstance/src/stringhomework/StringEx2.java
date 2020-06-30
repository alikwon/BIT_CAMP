package stringhomework;

public class StringEx2 {
	//내가쓴 답안
//	public static void main(String[] args) {
//		
//		String str = "990929-1010123";
//
//		StringBuffer str2 = new StringBuffer(str);
//		System.out.println(str2.deleteCharAt(6));
//
//	}
	public static void main(String[] args) {
		/* StringBuffer 사용 1- deleteCharAt / indexOf */
		StringBuffer str = new StringBuffer("990929-1010123");
		System.out.println(str.deleteCharAt(str.indexOf("-")));
		//indexOf = 특정 문자가 있는 인덱스 번호반환
		//deleteCharAt = 특정 인덱스에 있는 문자 삭제

		/* String Class 사용 2- replace */
		String str2 = "990929-1010123";
		System.out.println(str2.replace("-", ""));
		// replace = old 문자(열)을 new 문자(열)로 바꿔줌
		
		/* String Class 사용 - unicode로 숫자 판별 */
		String assemble = "";
		// unicode 반환
		for (int i = 0; i < str2.length(); i++) {
			int uniNum = str2.codePointAt(i);

			if (uniNum >= '0' && uniNum <= '9') {
				assemble += str2.charAt(i);
			}
		}
		System.out.println(assemble);
	}
}
