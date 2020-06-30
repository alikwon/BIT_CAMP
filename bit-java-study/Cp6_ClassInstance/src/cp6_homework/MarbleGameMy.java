package cp6_homework;
//문제2.
//다음조건을 만족하는 클래스를 구성하자. "구슬치기"와 "딱지치기"
//어린아이가 소유하고 있는 "구슬의 개수" 정보를 담을 수 있다.
//놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재한다.
//두 번째 조건은 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미하는 것이다.
//조건을 만족하는 클래스를 정의하였다면, 다음조건을 만족하는 인스턴스를 각각 생성하자. 
//( 하나의 클래스만 작성하자 )
//어린이 1의 보유자산  구슬 15개
//어린이 2의 보유자산  구슬 9개
//인스턴스의 생성이 완료되면 다음의 상황을 main 메서드 내에서 시뮬레이션 하자.
//“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
//“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
//마지막으로 각각의 어린이의 보유 구슬의 개수를 출력하고 프로그램 종료.


public class MarbleGameMy {
	
	int marbleNum;
	String name;
	
	//생성자 (이름입력)
	MarbleGameMy(String name){
		this.name=name;
	}
	//구슬 정보입력
	void data(int num) {
		marbleNum = num;
	}
	//승자가 패자의 구슬을 획득하는 메서드
	static void game(MarbleGameMy winner, MarbleGameMy loser,int num) {
		winner.marbleNum += num;
		loser.marbleNum -= num;
		System.out.println(
				winner.name+" 이(가) "+loser.name+"의 구슬을 "+num +"개 획득");
		
	}
	//보유구슬 출력
	void showData() {
		System.out.println("현재 보유 구슬: "+marbleNum);
	}
	
	public static void main(String[] args) {
		MarbleGameMy player1 = new MarbleGameMy("철수");
		MarbleGameMy player2 = new MarbleGameMy("영희");
		
		player1.data(15);	//철수 15개 영희 9개
		player2.data(9);
		
		game(player1, player2, 2);	//철수가 영희 구슬 2개 가짐
		System.out.println(player1.name);
		player1.showData();
		System.out.println(player2.name);
		player2.showData();
		
		
		game(player2, player1, 7);	//영희가 철수 구슬 7개 가짐
		System.out.println(player1.name);
		player1.showData();
		System.out.println(player2.name);
		player2.showData();
		
	}
}
