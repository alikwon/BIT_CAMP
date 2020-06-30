package cp15_0506;

public class TwoNumThread extends Thread {

	TwoNum twoNum;
	
	public TwoNumThread(TwoNum twoNum) {
		this.twoNum = twoNum;
	}

	@Override
	public void run() {
		
		twoNum.addOneNum();
		twoNum.addTwoNum();
		
		twoNum.addOneNum2();
		twoNum.addTwoNum2();
		
		twoNum.addOneNum3();
		twoNum.addTwoNum3();
	}
	
	
}
