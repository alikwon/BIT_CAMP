package cp3_exs;

public class OperatorEx20 {

	public static void main(String[] args) {
		//for문 순서 = i초기화, 조건 . i값은 ()안에서만 유효함(지역변수)
		for (int i = 1; i <= 10; i++) { //i가 1부터 1씩증가, 10이 될때까지 반복
			
			if (i % 3 == 0) {			//반복 되는동안 i가 3으로 나누어 떨어지면 출력
			
				System.out.println(i);	//3,6,9출력
	
			}
		}
	}
}
