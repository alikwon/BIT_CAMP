package cp10_0423;

public class Tv {
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
	void display() {
		System.out.println("티비실행");
	}
}
