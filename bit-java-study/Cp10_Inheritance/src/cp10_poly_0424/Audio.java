package cp10_poly_0424;

public class Audio extends Product {
	Audio(int price){
		super(price);
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
	void music() {
		System.out.println("노래들어영");
	}
	
}
