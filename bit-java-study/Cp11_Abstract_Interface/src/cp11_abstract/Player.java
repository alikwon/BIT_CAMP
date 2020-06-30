package cp11_abstract;

// class앞에 abstract 키워드가 있는 경우 추상클래스
// 추상클래스는 미완성된 클래스를 의미
// 클래스의 맴버중 추상 매서드를 하나라도 포함하면 >> 추상클래스
// 추상매서드 : 미완성 매서드
public abstract class Player {
	
	int currentPos;
	
	Player(){
		
	}
	
	//추상 매서드 : abstract 반환형 매서드이름(매개변수);
	abstract void play (int pos);
	
	//추상 매서드
	abstract void stop ();
	
	void play() {
		play(currentPos);
	}
}
