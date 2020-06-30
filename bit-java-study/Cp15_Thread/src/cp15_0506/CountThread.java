package cp15_0506;

public class CountThread extends Thread {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("입력없어서 끌게염");
		System.exit(0);
	}

}
