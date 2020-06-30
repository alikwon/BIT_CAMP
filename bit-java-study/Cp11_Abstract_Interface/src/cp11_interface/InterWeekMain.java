package cp11_interface;

import java.util.Scanner;

public class InterWeekMain implements InterWeek{

	public static void main(String[] args) {
		
		System.out.println("요일 선택");
		System.out.println("1.월, 2.화, 3.수, 4.목, 5.금, 6.토, 7.일");
		
		Scanner sc = new Scanner(System.in);
		
		switch(sc.nextInt()) {
		case InterWeek.MON:
			System.out.println("월요일");
			break;
		case InterWeek.TUE:
			System.out.println("화요일");
			break;
		case InterWeek.WED:
			System.out.println("수요일");
			break;
		case InterWeek.THU:
			System.out.println("목요일");
			break;
		case InterWeek.FRI:
			System.out.println("금요일");
			break;
		case InterWeek.SAT:
			System.out.println("토요일");
			break;
		case InterWeek.SUN:
			System.out.println("일요일");
			break;
			
		}
	}
}
