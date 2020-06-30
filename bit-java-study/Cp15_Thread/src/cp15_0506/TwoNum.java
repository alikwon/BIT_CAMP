package cp15_0506;

public class TwoNum {

	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	
	void addOneNum() {
		synchronized (this) {
			num1 += 1;
		}
	}

	void addTwoNum() {
		synchronized (this) {
			num1 += 2;
		}
	}

	void addOneNum2() {
		synchronized (key1) {
			num2 += 1;
		}
	}

	void addTwoNum2() {
		synchronized (key1) {
			num2 += 2;
		}
	}

	void addOneNum3() {
		synchronized (key2) {
			num3 += 1;
		}
	}

	void addTwoNum3() {
		synchronized (key2) {
			num3 += 2;
		}
	}

	Object key1 = new Object(); 
	String key2 = "k";
	
	public void showAllNums() {
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num3: " + num3);
	}
}
