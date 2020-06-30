package fruit;

public class FruitMain2 {

	public static void main(String[] args) {
		
		//seller1 객체 생성
		FruitSeller seller1= new FruitSeller(30,0,1000);//사과30,돈0,사과천원
		//seller2 객체 생성
		FruitSeller seller2= new FruitSeller(20,0,1500);
		
		FruitSeller seller3= new FruitSeller();//사과20,돈0,사과천원
		//buyer 객체 생성
		FruitBuyer buyer = new FruitBuyer(10000,0);		//만원,사과0
		
		
		//seller1에게 구매
		buyer.buyApple(seller1, 3000);
		
		//seller2에게 구매
		buyer.buyApple(seller2, 3000);
		
		//seller3에게 구매
		buyer.buyApple(seller3, 4000);
		
		
		seller1.showData("seller1 현재상황");
		seller2.showData("seller2 현재상황");
		seller3.showData("seller3 현재상황");
	}

}
