package cp3_exs;

public class OperatorEx17 {

	public static void main(String[] args) {
		float pi = 3.141592f;				//원주율
		float shortPi = 
				(int)(pi * 1000) / 1000f;	//소수점 3번째 이후를 떼버림
		
		System.out.println(shortPi);		//3.141 출력
											//1000 > 100 이면 3.14

	}

}
