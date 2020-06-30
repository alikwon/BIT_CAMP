package cp15_0506;

public class IncThreadMain {

	public static void main(String[] args) {
		
		Increment inc = new Increment();
		
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		
		it1.start(); // 참조되는 시점때문에 원하는 결과를 못얻음
		it2.start();
		it3.start();
		
		try {
			it1.join(); //동시참조를 막지 못함 ==> increment매서드를 수정
			it2.join();
			it3.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(inc.getNum());
		
	}
}
