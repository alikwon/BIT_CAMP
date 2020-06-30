package cp10_poly_0424;

//상품 객체들의 상위클래스!
public class Product {

	final int price; // 제품가격
	int bonusPoint; // 제품구입 시 받는 포인트

	Product(int price) {
		this.price = price;
		this.bonusPoint = this.price / 10;// 제품의 10%는 포인트
	}
	void display() {
		System.out.println("PRO");
	}
	@Override
	public String toString() {
		
		return "";
	}
	

}
