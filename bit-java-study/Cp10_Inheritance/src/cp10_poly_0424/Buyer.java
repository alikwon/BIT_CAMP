package cp10_poly_0424;

public class Buyer {

	int money;// buyer 보유 금액
	int bonusPoint;// buyer 보유 point
	Product[] item;
	int numOfProduct;

	Buyer() {
		this.money = 100000;
		this.bonusPoint = 0;
		item = new Product[10];
		numOfProduct = 0;
	}

	// main에서 타입을 따로만들었다면
	// 각 타입의 매개변수를 받아야함
//	void buy(Tv tv) { 
//		
//	}
//	void buy(Computer com) {
//		
//	}
//	void buy(Audio aud) {
//		
//	}

	// but main에서 타입을 상위클래스로 통일 시켜주면
	// 일일히 매서드를 만들 필요없음 >> 확장성
	void buy(Product p) {

		// 구매 상품의 금액과 buyer의 보유금액을 비교해서 구매여부 처리
		if (money < p.price) {
			System.out.println("거지네");
			return;
		}

		// 구매 처리
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;

		item[numOfProduct++] = p;
		// numOfProduct++;

		System.out.println(p + " 사줘서 고마웡");
		// toString 오버라이드 해서 p를 출력하면
		// 주소값이 아닌 오버라이딩된 return값 출력
	}

	// 영수증
	void summary() {
		int sum = 0; // 구매제품의 총액
		int points = 0; // 구매한 제품 포인트의 총합

		String itemList = ""; // 구매 제품 목록

		for (int i = 0; i < numOfProduct; i++) {
			itemList += item[i]+", ";
			points += item[i].bonusPoint;
			sum += item[i].price;
		}
		
		System.out.println("구매 목록========");
		System.out.println("구매하신 제품은 ");
		System.out.println(itemList+ "입니다");
		for(int i =0; i<numOfProduct; i++) {
			System.out.println(item[i]+" = "+item[i].price);
		}
		System.out.println("총 금액 : "+sum);
		System.out.println("총 포인트 : "+points);
	}	

	
	
	
	
	
	
	
}
