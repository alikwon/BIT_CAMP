package cp4_homework;

public class Ex14 {

	public static void main(String[] args) {
//		다음 식을 만족하는 조합을 찾는 프로그램 작성. 
//		  A B
//		+ B A
//		------
//		  9 9

		// A와 B는 0~9, A+B= 9인 숫자 찾기
		for (int a = 0; a < 10; a++) {

			for (int b = 0; b < 10; b++) {
				if (b+a==9) {
					// if(b+a == 9)
					System.out.println("a : " + a + " b : " + b+"\n");
					
					System.out.println
					(a + "" + b + " + " + b + "" + a + " = " + (a + b) + (a + b));
					System.out.println("============");
				}
//		for (int num=0;num<10;num++) {
//			int c,d;
//			c=num;
//			d=9-c;
//			System.out.println(num+""+b);
//		}
			}
		}
	}
}
