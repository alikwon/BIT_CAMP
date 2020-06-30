package cp2_0409;

public class CastingEx2 {

	public static void main(String[] args) {
		
		byte b = 10; //byte형 변수 선언
		int i = (int)b; //명시적 형변환
		
		System.out.println("i=" + i);
		System.out.println("b=" + b); //i와 b 모두 10으로 출력
		
		int i2 = 300; //int형 변수 선언
		byte b2 = (byte)i2;  //int = 4바이트.
		
		System.out.println("i2=" + i2); 
		//변수선언한 300이 출력
		System.out.println("b2=" + b2); 
		//바이트가 잘리면서 전혀 다른 숫자가 출력

	}

}
