package cp15_0506;

public class Calculator {

	int opCnt = 0; // 메서드의 실행횟수를 count 하는 변수

	//인스턴스 자체가 잠금처리 되어버림  ==> 동기화블럭 처리
//	synchronized int add(int n1, int n2) {
//		opCnt++;
//		return n1 + n2;
//	}
//
//	synchronized int min(int n1, int n2) {
//		opCnt++;
//		return n1 - n2;
//	}
	
	//메서드단위의 동기화처리는 성능문제가 있을수 있어서
	//동기화 블럭 사용
	int add(int n1, int n2) {
		System.out.println("덧셈");
		synchronized (this) {opCnt++;} //동기화 블럭
		return n1 + n2;
	}

	synchronized int min(int n1, int n2) {
		System.out.println("뺄셈");
		synchronized (this) {opCnt++;}
		return n1 - n2;
	}
	
	void showOpCnt() {
		System.out.println("연산의 횟수 : "+opCnt+"번");
	}
	
}
