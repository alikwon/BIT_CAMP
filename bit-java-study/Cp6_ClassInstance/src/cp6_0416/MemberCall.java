package cp6_0416;

public class MemberCall {
	
	//instance 변수
	int iv = 10;
	
	//class 변수, static 변수
	static int cv = 20;
	
	int iv2= cv;
//	static int cv2 = iv; //클래스변수는 인스턴스 변수 사용 불가
	static int cv2 = new MemberCall().iv; //굳이 사용하려면 객체생성해야함
	
	static void staticMethod() {
		//static 맴버 출력
		System.out.println(cv);
		
		//instance 맴버 출력
		//System.out.println(iv);
		//static매서드에서 인스턴스변수 바로사용x
		//객체생성을 한 후에 인스턴스변수 참조가 가능
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv);
		
	}
	
	void instanceMethod() {
		//static 맴버 출력
		System.out.println(cv);
		
		//instance 맴버 출력
		System.out.println(iv);
		//인스턴스 매서드에서는 객체생성 없이 인스턴스변수 사용가능
		
	}
	public static void main(String[] args) {
		staticMethod();
	}
		
}
