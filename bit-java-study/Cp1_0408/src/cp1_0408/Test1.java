package cp1_0408;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("2 + 5 = " + 2 + 5); 
		/* 문자열로 먼저 변경 후에 붙여줌
		 "문자열"+"2" >> "문자열 2" + 5 >> "문자열 25" */
		System.out.println("2 + 5 = " + (2+5));
		// 괄호먼저 처리 해주기 때문에 7이 나옴
	}

}