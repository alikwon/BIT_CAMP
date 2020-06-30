package cp10_0423;

public class TvCaption extends Tv{
	String text;
	void caption() {
		System.out.println("자막" +text);
	}
	
	void display() {
		super.display();
		caption();
	}
}
