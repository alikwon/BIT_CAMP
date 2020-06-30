package cp4_0413;

public class DoWhileBasic {

	public static void main(String[] args) {
		int num = 1; // 반복의 조건을 체크
					 // 변수가 while조건에 들어가지 않더라도 한번은 수행
		
		do {
			System.out.println("I like JAVA" + num);
			num++; 	 // 탈출의 조건
		} while (num < 5);

	}

}
