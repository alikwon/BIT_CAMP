package Cp12_0428;

import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이입력하세요");
		int age = sc.nextInt();
		sc.nextLine();
		try {
			if(age <0) {
//			Exception e = new Exception("고의임");
				AgeInputException e = new AgeInputException();
				throw e; // 강제적 예외 발생 지점
				
				
			}
		}catch(AgeInputException e){
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");
	}
}
