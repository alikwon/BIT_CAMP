package fruit;

/*	작성자 : 권재준
	수정일 : 2020.04.17
	수정내용 : 생성자를 통한 변수 초기화
*/
public class FruitBuyer {
//	// 속성
//	// 보유중인 돈
//	// 구매후 가질 사과의 개수
//	int bMoney = 10000;
//	int bApple = 0;
	
	//변수의 명시적 초기화 변경
	int bMoney;
	int bApple;
	
	// 생성자
	FruitBuyer(){
		bMoney = 5000;
		bApple = 0;
	}
	
	FruitBuyer(int money,int num){
		bMoney = money;
		bApple = num;
	}
	// 기능
	// 1) 사과 판매자 찾기
	// 2) 지출할 돈 정의
	// 3) 판매자에게 돈을 주고 판매 요청 ==> 사과를 받음
	// 4) 현재 사과의 개수를 받은 개수만큼 증가
	// 5) 지출한돈을 보유중인 돈에서 뺀다

	// 참조변수 : 해당타입 객체의 주소값을 저장
	void buyApple
		(FruitSeller seller, int money) {// 1- 1)
		int num = 
				seller.saleApple(money); // 2- 2) 3)==>구매한 사과의 개수 num에 대입
		bMoney -= money;				 // 4- 5)
		bApple += num; 					 // 3- 4)

	}

}