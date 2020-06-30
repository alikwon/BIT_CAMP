package cp3_exs;

public class OperatorEx23 {

	public static void main(String[] args) {
		float f = 0.1f;			//float 변수 선언
		double d = 0.1;			//double 변수 선언 
		double d2 = (double)f;	//float f 를 double로 변환
		
		System.out.println("10.0==10.0f ? " + (10.0 == 10.0f));	//true
		System.out.println("0.1==0.1f ? " + (0.1 == 0.1f));		//false	
		// 0.1f는 0.1이 아닌 0.10000000149011612(근사값)로 저장됨 
		System.out.println("f=" + f);	//0.1출력
		System.out.println("d=" + d);	//d에 0.10000000000000001로 저장된다.
		System.out.println("d2=" + d2);	//0.1f를 double로 변환하면서 표현 범위 늘어남
		System.out.println("d==f ? " + (d == f));	// 0.1의 근사값이긴 하나 서로 다름
		System.out.println("d==d2 ? " + (d == d2));
		System.out.println("d2==f ? " + (d2 == f));	

	}

}
