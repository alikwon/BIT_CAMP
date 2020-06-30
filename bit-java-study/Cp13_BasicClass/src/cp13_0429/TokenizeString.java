package cp13_0429;

import java.util.StringTokenizer;

public class TokenizeString {
	
	public static void main(String[] args) {
		
		String phoneNum = "Tel 81-02-997-2059 test";
		
		// 구분자 사용없이
		StringTokenizer st1 = new StringTokenizer(phoneNum);
		while(st1.hasMoreTokens()) { // 공백을 구분해서 반환해줌
			System.out.println(st1.nextToken());
		}
		System.out.println("-------------------------");
		
		
		// 구분자 사용
		// "-"를 구분자로 하여 반환해줌, 
		//" -"하면 공백까지 구분해줌, true 붙이면 구분자도 같이 나옴
		StringTokenizer st2 = new StringTokenizer(phoneNum," -",true);
		while(st2.hasMoreTokens()) { 
			System.out.println(st2.nextToken());
		}
		
		
	}
	
}
