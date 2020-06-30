package fruit;

public class FruitMain {

	public static void main(String[] args) {

		// 판매자 생성 ( 인스턴스화 )
		FruitSeller sell = new FruitSeller();
		// new FruitSeller();
		// ==> 객체 생성, 메모리에 변수와 변수의 데이터, 메서드 코드가 저장
		
		// 구매자 생성 ( 인스턴스화 )
		FruitBuyer buy = new FruitBuyer();
		
		
		// 구매자가 사과를 구매>> 메인 > 바이에플 > 세일 에플
		buy.buyApple(sell, 10000);
		
		System.out.println("< 판매 정보 출력 >");
		System.out.println("현재 사과의 개수 : " + sell.sApple);
		System.out.println("판매 금액 : " + sell.sMoney);

		System.out.println("====================");
		System.out.println("< 구매 정보 출력 >");
		System.out.println("현재 보유한 사과 : " + buy.bApple);
		System.out.println("보유 금액 : " + buy.bMoney);
	}

}