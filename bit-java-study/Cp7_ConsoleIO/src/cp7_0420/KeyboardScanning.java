package cp7_0420;

import java.util.Date;
import java.util.Scanner;

class KeyboardScanning {
	public static void main(String[] args) {
		//Scanner 치고 ctrl+ Space
		//ctrl + shift + o >> 한번에 자동 추가
		Scanner sc = new Scanner(System.in);
		Date date = new Date();
		
		System.out.println("숫자 입력 : ");
		int num1 = sc.nextInt(); // 정수 값을 하나 가져옴
		
		System.out.println("숫자 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println("숫자 입력 : ");
		int num3 = sc.nextInt();

		int sum = num1 + num2 + num3;
		System.out.printf( //문자열 조합
				"입력된 정수는 %d, %d, %d 입니다. 숫자들의 합은 %d 입니다."
				,num1,num2,num3,sum);
	}
}