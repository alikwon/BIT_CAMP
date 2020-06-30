package cp15_0506;

public class SumThread extends Sum implements Runnable {

	int start; // 시작값
	int end; // 끝값

	public SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			addNum(i);
		}
	}

}
