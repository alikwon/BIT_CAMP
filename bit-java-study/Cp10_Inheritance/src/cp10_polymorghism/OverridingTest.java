package cp10_polymorghism;

public class OverridingTest {

	public static void main(String[] args) {
		
		
		// 다형성 : 상위클래스 타입의 참조변수에 하위클래스의 인스턴스 참조
		Speaker sp = new BaseEnSpeaker();
		//참조변수 sp는
		//BaseEnSpeaker 인스턴스 맴버중
		//speaker 가 가지던 맴버만 사용한다
		
		sp.showCurrentState();
		
		System.out.println("--------------------------");
		BaseEnSpeaker bs=new BaseEnSpeaker();
		bs.setVolume(10);
		bs.setBaseRate(20);
		bs.showCurrentState();
		
		System.out.println(bs);//toString 호출

	}

}
