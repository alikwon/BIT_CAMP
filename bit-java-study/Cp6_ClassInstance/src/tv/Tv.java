package tv;

public class Tv {
	
	//Tv의 속성(변수) => 멤버변수, 인스턴스 변수
	String color;	//Tv 색상 값  <==변수 사전만들때
	boolean power;	//Tv 전원 상태
	int channel;	//Tv 채널 값
	
	//tv의 기능 -> 메서드, 클래스의 맴버
	//tv의 전원을 켜고 끄는 기능 : 상태 값만 변경 ==>반환 필요 x
	
	void power() {
		
//		if(power==true) {
//			power = false;
//		} else {
//			power = true;
//		}
//		논리값을 반대로 바꿔주는 것 >>>한줄로 줄일수 있음 >>>
		power = !power;
	}
	
	//채널을 올린다 : 변경
	void channelUp() {
			
//			channel = channel+1;
//			channel +=1;
//			channel++;
		++channel;
	}
	
	//채널을 내린다
	void channelDown() {
		channel--;
	}
	
	//채널값을 변경
	void channelChange(int ch) {
		channel=ch;
	}
}
