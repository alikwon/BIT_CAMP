package cp10_poly_0424;

public class Tv extends Product {
	int a=0;
	// 상위클래스에 초기화해야하는 생성자가 있기때문에
	// 상위클래스의 생성자를 호출해줘야 한다
	Tv(int price) {
		super(price);
		this.bonusPoint= price/2;
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
	void display() {
		System.out.println("Tv봐영");
	}
}
