package cp10_poly_0424;

public class Computer extends Product {
	
	Computer(int price){
		super(price);
	}

	@Override
	public String toString() {
		return "컴터";
	}
	
	void programming() {
		System.out.println("코딩 해영");
	}

}
