package fruit;


/*
 	작성자 :권재준
 	수정일 : 2020.04.17
 	수정 내용 : 생성자를 통한 변수 초기화 , 현재 데이터 현황 출력메서드
 */
public class FruitSeller {

	// 속성(맴버변수)
	// 사과 개수 ==> 맴버변수(인스턴스변수)
	// 수입
	// 사과 가격==> final로 고정
//	int sApple = 10;		
//	int sMoney = 0;			
//	final int price = 1000; 
	
	// 수정 : 변수의 명시적 초기화 변경
	int sApple;		// 사과 개수 ==> 맴버변수(인스턴스변수)
	int sMoney;			// 수입
	final int PRICE; // 사과 가격 ==> final로 고정
	
	FruitSeller(){
//		sApple = 20;
//		sMoney = 0;
//		PRICE = 1000;
		this(20, 0 ,1000);// 생성자 안에서 또다른 생성자를 호출
						  // 밑의 생성자를 가리킴 ↓
	}
	
	FruitSeller(int num, int money, int price){
		sApple = num;
		sMoney = money;
		PRICE = price;
	}
//	FruitSeller(int sApple, int sMoney, int price){
//		this.sApple = sApple;
//		this.sMoney = sMoney;
//		PRICE = price;
//	}
//	
	
	// 기능(메서드)
	// 1) 돈을 받음(매개변수 int money)
	// >> 매개변수 : 메서드를 수행할때 필요한 데이터
	// 2) 받은 돈에 맞춰 사과의 개수를 구해야 함
	// 3) 나의 사과 개수에서 주는 사과 개수를 빼줌
	// 4) 받은 금액을 내 수입에 더해줌
	// 5) 사과개수 반환 => 반환데이터 int return 사과개수
	int saleApple(int money) {	// 1-반환타입, 매개변수 타입

		int num = money / PRICE;// 2- 2)
		sApple -= num;			// 4- 3)
		sMoney += money;		// 5- 4)
		return num;				// 3- 5)
	}
	void showData(String seller) {
		System.out.println(""+seller);
		System.out.println("현 보유 사과 : "+sApple + ", 현 보유 금액"+sMoney);
	}
}