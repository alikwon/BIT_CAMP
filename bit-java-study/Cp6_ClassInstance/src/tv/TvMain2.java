package tv;

public class TvMain2 {
	
	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();	//하나의 인스턴스를 여러개의 참조변수
		
		System.out.println(tv1==tv2);// 주소값 같은지 확인
									 //false = 서로다른 주소값
		
		System.out.println("=============");
		System.out.println("tv1 channel : "+tv1.channel);
		System.out.println("tv2 channel : "+tv2.channel);
		
		System.out.println("-------------");
		
		tv1.channel = 10;
		System.out.println("tv1의 채널을 10으로 변경");
		
		System.out.println("tv1 channel : "+tv1.channel);
		System.out.println("tv2 channel : "+tv2.channel);
	}

}
