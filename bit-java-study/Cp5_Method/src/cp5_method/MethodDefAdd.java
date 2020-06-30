package cp5_method;

public class MethodDefAdd {
			//2. static(전역의) : 먼저 메모리에 올림
	public static void main(String[] args) { //프로그램은 메인에서 시작!
		
		System.out.println("프로그램의 시작");
		hiEveryone(10); //1. 매서드에 static을 안쓰면 오류
		hiEveryone(14);
		hiEveryone(16);
		hiEveryone(12);
		hiEveryone(25);
		hiEveryone(34);
		//ctrl+ 마우스 를 올리면 해당 메서드로 감
		
//		System.out.println("프로그램의 끝");
//		System.out.println("좋은 아침 입니다");		
//		System.out.println("제 나이는 "+age+"세 입니다");
//		System.out.println("좋은 아침 입니다");		
//		System.out.println("제 나이는 "+age+"세 입니다");
//		System.out.println("좋은 아침 입니다");		
//		System.out.println("제 나이는 "+age+"세 입니다");
//		System.out.println("좋은 아침 입니다");		
//		System.out.println("제 나이는 "+age+"세 입니다");
		
		
	}
	
	//인사말 출력, 나이값을 받아서 나이를 출력하는 메서드
	//기능 : age 출력 ==> 굳이 반환이 필요없으므로 return이 없다
	//void = 반환이 없다
	//매개변수가 있던 없던 ()가 있어야함
	
	//3. static이 안붙어서 메모리에 안올라감

	//static 으로 선언된 변수나 메소드는 
	//해당 클래스의 인스턴스 여부와 상관없이 
	//바로 접근이 가능하고 사용이 가능하다
	static void hiEveryone(int age) { 
		System.out.println("좋은 아침 입니다");		//인사말 출력
		System.out.println("제 나이는 "+age+"세 입니다");
	}
}