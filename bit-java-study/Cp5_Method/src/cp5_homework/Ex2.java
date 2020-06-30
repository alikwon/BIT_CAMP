package cp5_homework;

//	문제2.
//	두 개의 정수를 전달 받아서, 두수의 절대값을 계산하여 출력하는 메서드와 
//	이 메서드를 호출하는 main메서드를 정의해 보자
//	단 메서드 호출 시 전달되는 값의 순서에 상관없이 절대값이 계산되어서 출력되어야 한다.
public class Ex2 {

	void absValue(int a, int b) {
//		a=(a>0)?a :a;
//		b=(b>0)?b:-b;
//		System.out.println("a의 절대값 : "+a+"b의 절대값 : "+b);
		if(a<0) 
			a=-a;
		System.out.println("a의 절대값 : "+a);
		
		if(b<0) 
			b=-b;
		System.out.println("b의 절대값 : "+b);
		
	}

	public static void main(String[] args) {
		Ex2 ex = new Ex2();
		ex.absValue(2, -3);
		
	}
}