package cp5_homework;

//	문제1
//	두 개의 정수를 전달받아서, 
//	두수의 사칙연산 결과를 출력하는 메서드와 이 메서드를 호출하는 main메서드를 정의해보자.
//	단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.
public class Ex1 {

	
	void calc(int a,int b) {
		System.out.println("덧셈결과 : "+(a+b));
		System.out.println("뺄셈결과 : "+(a-b));
		System.out.println("곱셈결과 : "+(a*b));
		System.out.println("나눗셈 몫 : "+(a/b)+", 나머지 : "+ (a%b));
	}
	
	public static void main(String[] args) {
		Ex1 ex= new Ex1();
		ex.calc(3, 5);
	}
}