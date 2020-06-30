package cp4_0413;

public class BreakBasic {

	public static void main(String[] args) {
		int num = 1;
		boolean search = false;
		
		while (num < 100) {		// 1<= num < 100
			if (num % 5 == 0 && num % 7 == 0) {
				search = true;	//5와 7의 최소공배수 가 나올 때 실행
				break;			//==> 실행 후 while문 탈출
			}
			num++;
		}
		if (search)
			System.out.println("찾는 정수 : " + num); 
			//search가 참일때 출력
		else
			System.out.println("5의 배수이자 7의 배수를 찾지 못했습니다."); 
			//search가  거짓일때 출력

	}

}
