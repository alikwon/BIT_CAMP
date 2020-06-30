package cp3_0410;

public class LogicOp {

	public static void main(String[] args) {
		// 정수 데이터 2개를 받음
		//int num1 = 10 , num2 = 20; 
		//같은 타입이면 " , "를 통해서 선언 가능
		
		int num1 = 10; 				  //첫번째 정수 데이터
		int num2 = 20;				  //두번째 정수 데이터
		
		boolean check1 = num1 > num2; //num1 이 num2 보다 큰 수인지 확인
									  //큰경우 true 작은경우 false
		
		
		boolean check2 = num1 == num2;//num1 과 num2 와 같은 경우 
		
		//syso > Ctrl+spacebar (단축키)
		if(check1) {
			System.out.println("num1의 값이 num2 값보다 크다");
		} 
		else {
			System.out.println("num1의 값이 num2 값보다 작다");	//check1 = false이므로 else가 출력			
		}
		
		if(check2) {
			System.out.println("num1의 값과 num2 값이 같다"); 
		} else {
			System.out.println("num1의 값과 num2 값이 다르다");	//check2 = false이므로 else가 출력
		}
		
		
		//성인 여성중 기혼자에게만 메세지를 출력//
		
		int age = 20; 			//성인
		char gender = 'w'; 		//여성 , 대소문자 구분!! 
		boolean mCheck = true;	//기혼자
		
		boolean result = age > 19 && gender == 'w' && mCheck; //gender는 유니코드 값 비교
		
		if(result) {
			System.out.println("메세지를 보냅니다");	//result = true 이므로 출력
		} 
		//false 일 경우는 필요없기 때문에 else를 굳이 안써도 무방함 
	}

}
