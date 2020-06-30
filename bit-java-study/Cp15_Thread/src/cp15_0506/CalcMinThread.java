package cp15_0506;

public class CalcMinThread extends Thread {
	
	Calculator cal;
	
	public CalcMinThread(Calculator c) {
		cal = c; // 주입
	}

	@Override
	public void run() {
		System.out.println(cal.min(2, 1));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(cal.min(4, 2));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
