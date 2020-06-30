package ex2;

//	문제2.
//	예제 InstanceOf.java를 instanceof 연산자를 사용하지 않는 형태로 변경하고자 한다. 
//	즉 클래스의 상속관계를 그대로 유지하면서,
//	instanceof 연산자를 사용하지 않고도 동일한 실행결과를 보일 수 있어야 한다.
//	변경되어야 할 wrapBox 메소드를 아래에 제시.
//	Public static void wrapBox(Box box)
//	{
//	box.wrap();
//	}
//	HINT. 메소드 오버라이딩
	
public class InstanceOf {
	public static void wrapBox(Box box) {
	
		
		box.wrap();

		
//		if (box instanceof GoldPaperBox)
//			((GoldPaperBox) box).goldWrap();
//		else if (box instanceof PaperBox)
//			((PaperBox) box).paperWrap();
//		else
//			box.simpleWrap();
	}

	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
		
	}	

}

class Box {
	public void wrap() {
		System.out.println("simple wrap"); // 만들어서
	}
	public void simpleWrap() {
		System.out.println("simple wrap");
	}

}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("paper wrap");
	}

	@Override
	public void wrap() {
		System.out.println("paper wrap");	// 오버라이드
	}
	
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("gold wrap");
	}
	
	@Override
	public void wrap() {
		System.out.println("gold wrap");	// 오버라이드
	}

}
