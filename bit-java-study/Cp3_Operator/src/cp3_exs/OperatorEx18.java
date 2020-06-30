package cp3_exs;

public class OperatorEx18 {

	public static void main(String[] args) {
		// Math.round() : 소수점 첫째자리에서 반올림한 값을 반환
		float pi = 3.141592f;
		float shortPi = Math.round(pi * 1000) / 1000f;
		// 3141.592를 반올림해서 3142/1000f
		
		System.out.println(shortPi); //3.142출력

	}

}
