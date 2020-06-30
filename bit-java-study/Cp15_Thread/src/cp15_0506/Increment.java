package cp15_0506;

public class Increment {

	int num = 0;

	void increment() {
		synchronized (this) {
			num++;
		}
	}

	int getNum() {
		return num;
	}
}
 