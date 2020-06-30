package cp15_0506;

public class CalcAddThread extends Thread{

	Calculator cal;
	
	public CalcAddThread(Calculator c) {
		cal = c; // 주입
	}

	@Override
	public void run() {
		System.out.println(cal.add(1, 2));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(cal.add(2, 4));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
