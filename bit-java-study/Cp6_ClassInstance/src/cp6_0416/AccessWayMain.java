package cp6_0416;

public class AccessWayMain {

	public static void main(String[] args) {
		
		System.out.println(AccessWay.num);
		AccessWay.num++;	//클래스이름 . 클래스변수
		System.out.println(AccessWay.num);
		
		//static변수가 아닐시
		AccessWay ac = new AccessWay();	//인스턴스 생성
		System.out.println(ac.num2);
		System.out.println(ac.num);//static변수도 가능
	}

}
