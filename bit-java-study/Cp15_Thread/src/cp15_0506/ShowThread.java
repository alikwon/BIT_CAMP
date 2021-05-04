package cp15_0506;

//쓰레드 클래스를 만들기 위해 thread상속
public class ShowThread extends Thread {

	String threadName;

	public ShowThread(String name) {
		threadName = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("하이염! "+ threadName + "임");
			
			try {sleep(100);}
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}

}
