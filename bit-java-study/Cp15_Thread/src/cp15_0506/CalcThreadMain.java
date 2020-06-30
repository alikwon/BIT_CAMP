package cp15_0506;

public class CalcThreadMain {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		CalcAddThread cat = new CalcAddThread(calc);
		CalcMinThread cmt = new CalcMinThread(calc);
		
		cat.start();
		cmt.start();
		
		try {
			cat.join();
			cmt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		calc.showOpCnt();
	}
}
