package cp15_0506;

public class TwoNumMain {

	public static void main(String[] args) {
		
		TwoNum tn = new TwoNum();
		
		TwoNumThread tnt = new TwoNumThread(tn);
		TwoNumThread tnt2 = new TwoNumThread(tn);
		TwoNumThread tnt3 = new TwoNumThread(tn);
		
		tnt.start();
		tnt2.start();
		tnt3.start();
		
		try {
			tnt.join();
			tnt2.join();
			tnt3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tn.showAllNums();
	}
	
}
