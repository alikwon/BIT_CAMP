package cp15_0506;

public class SumThreadMain {

	public static void main(String[] args) {

		// Runnable 을 구현하는 인스턴스 생성
		SumThread sumt1 = new SumThread(1, 50);
		SumThread sumt2 = new SumThread(51, 100);

		// Thread 인스턴스 생성
		Thread t1 = new Thread(sumt1);
		Thread t2 = new Thread(sumt2);

		// 실행 흐름 생성
		t1.start(); // run() 호출 프로그램 생성
		t2.start(); // numd의 값을 변경시켜주고 있음
		
//		t1.join(3000); //3초동안 cpu가 t1만 실행하도록
		
		try {
			t1.join(); //1~50까지는 보장을 받음. 종료될때까지 실행
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//우리가 원하는 5050이 나오지 않음 ==> 쓰레드의 제어가 필요함
		System.out.println("1~100까지의 합 = " + 
							(sumt1.getNum() + 
							sumt2.getNum()));
	}
}
