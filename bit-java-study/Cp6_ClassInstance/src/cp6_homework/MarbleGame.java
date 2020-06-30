package cp6_homework;

//	문제2.
//	다음조건을 만족하는 클래스를 구성하자. "구슬치기"와 "딱지치기"
//	어린아이가 소유하고 있는 "구슬의 개수" 정보를 담을 수 있다.
//	놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재한다.
//	두 번째 조건은 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미하는 것이다.
//	조건을 만족하는 클래스를 정의하였다면, 다음조건을 만족하는 인스턴스를 각각 생성하자. 
//	( 하나의 클래스만 작성하자 )
//	어린이 1의 보유자산  구슬 15개
//	어린이 2의 보유자산  구슬 9개
//	인스턴스의 생성이 완료되면 다음의 상황을 main 메서드 내에서 시뮬레이션 하자.
//	“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
//	“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
//	마지막으로 각각의 어린이의 보유 구슬의 개수를 출력하고 프로그램 종료.

//	객체 : 철수 , 영희 , (상태에 따라서) 구슬
//	속성(상태값) : 구슬의 개수
//	기능 : 구슬을 "주고 받는" 게임
//	철수 영희 모두 구슬을 보유, 같은 게임 ==> 클래스 1개의 관점
public class MarbleGame {
	//구슬 개수 변수
	int marbleNum;
	
	//생성자
	MarbleGame(int num){
		marbleNum = num;
	}
	//구슬 개수 설정
//	void setMarble(int num) {
//		marbleNum = num;
//	}
	
	//구슬 게임
	void gameWin(MarbleGame winner,MarbleGame loser, int num) {
		winner.marbleNum += num;	//플레이어1의 구슬
		loser.marbleNum -=num;//플레이어2의 구슬
	}
	
	//구슬 개수 출력
	void showData() {
		System.out.println("현재 보유 구슬 : "+marbleNum);
	}
	
	public static void main(String[] args) {
		
		//철수
		MarbleGame boy = new MarbleGame(15);
		//영희
		MarbleGame girl = new MarbleGame(9);
		
		//철수구슬 : 15, 영희구슬 : 9
		//boy.setMarble(15);
		//girl.setMarble(9);
		
		System.out.println("철수 구슬 : "+boy.marbleNum+", 영희 구슬 : "+girl.marbleNum);
		System.out.println("---------------------------");
		//1게임 = 철수가 영희 구슬 2개 획득
		boy.gameWin(boy,girl, 2);
		System.out.println("철수");
		boy.showData();
		System.out.println("영희");
		girl.showData();
		System.out.println("--------------");
		
		//2게임 = 영희가 철수 구슬 7개 획득
		girl.gameWin(girl,boy, 7);
		System.out.println("철수");
		boy.showData();
		System.out.println("영희");
		girl.showData();
		
		
	}
}




