package cp10_0423;

public class TvSmart extends Tv {

	
	String ch = "youtube";
	
	void display() {
		super.display();
		System.out.println(ch +"방송 시청합니다");
	}
}
