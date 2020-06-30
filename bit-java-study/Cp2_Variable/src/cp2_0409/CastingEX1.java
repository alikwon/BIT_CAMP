package cp2_0409;

public class CastingEX1 {

	public static void main(String[] args) {
		
		double d = 100.1;  //double형 변수 선언 
		int i = 100; // int형 변수 선언
		int result = i + (int)d;
		//d값을 형변환 후 i를 더함 >> result 에 저장
		
		System.out.println("d=" + d);
		System.out.println("i=" + i);
		System.out.println("result=" + result);
		//100.1을 int 변환하면 .1이 잘려서 출력
		
	}

}
