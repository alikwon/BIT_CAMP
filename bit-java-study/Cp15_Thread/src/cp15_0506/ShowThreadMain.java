package cp15_0506;

public class ShowThreadMain {

	public static void main(String[] args) {

		// Thread instance 생성
		ShowThread st1 = new ShowThread("	멋진 쓰레드");
		ShowThread st2 = new ShowThread("예쁜 쓰레드");

		// Thread 실행 : 새로운 프로그램 코드 실행의 흐름
		st1.start(); // 이 쓰레드의 run()을 실행함
		st2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("메인메서드가 실행중이염");
		}

	}
}
