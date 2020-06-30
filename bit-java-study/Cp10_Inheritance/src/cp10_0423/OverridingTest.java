package cp10_0423;

public class OverridingTest {

	public static void main(String[] args) {
		
		BaseEnSpeaker bs=new BaseEnSpeaker();
		bs.setVolume(10);
		bs.setBaseRate(20);
		bs.showCurrentState();
		
		System.out.println(bs);//toString 호출

	}

}
