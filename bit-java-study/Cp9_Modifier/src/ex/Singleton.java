package ex;

public class Singleton {
	
	//1. 생성자의 접근제어지시자 : private >> 인스턴스 생성 불가!
	private Singleton() {}
	
	
	//2. 공유할 객체 생성
	private static Singleton s = new Singleton(); //인스턴스변수
	//static 을 붙이면 외부에서 접근이 가능한 문제점
	// >> private 붙여줌
	
	//3. 참조값 반환하는 메서드 생성 > 외부에서 사용할수있도록
	public static Singleton getInstance() {//인스턴스 메서드라서 생성이 안됨
		return s;
	}
	
	public void print() {
		System.out.println("Singleton !!");
	}
	
}
