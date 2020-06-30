package cp3_exs;

public class OperatorEx7 {

	public static void main(String[] args) {
		boolean power = false;		//논리형 변수 선언
		
		System.out.println(power);	//출력 : false
		
		power = !power;				//power의 값이 false에서 true로
		
		System.out.println(power);	//출력 : true
		
		power = !power;				// power의 값이 true에서 다시 false로
		
		System.out.println(power);	//출력 : false

	}

}
