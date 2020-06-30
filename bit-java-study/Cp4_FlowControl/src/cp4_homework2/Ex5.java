package cp4_homework2;

public class Ex5 {

	public static void main(String[] args) {
//		for (int i = 0; i <= 10; i++) {
//			for (int j = 0; j <= i; j++)
//				System.out.print("*");
//			System.out.println();
//		}
//			for >> while
		int i=0;
		while (i<=10) {
			int j=0;		//안쪽에 선언
			while (j<=i) {
				j++;
				System.out.print("*");
				
			}
			i++;
			System.out.println();
		}
		
		
		

	}
}