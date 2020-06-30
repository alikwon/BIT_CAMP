package cp4_homework2;

public class Ex8 {

	public static void main(String[] args) {
//		[8] 방정식 2x+4y=10의 모든 해를 구하시오.
//		단, x와 y는 정수이고 각각의 범위는 0<=x<=10,  0<=y<=10 이다.
//				 
//				[실행결과]
//				x=1, y=2
//				x=3, y=1
//				x=5, y=0
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (i * 2 + j * 4 == 10) {
					System.out.println("x= " + i + ", y= " + j);
				}
			}
		}
	}
}
