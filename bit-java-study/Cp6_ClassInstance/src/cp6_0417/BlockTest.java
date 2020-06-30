package cp6_0417;

public class BlockTest {
	static {	//클래스 초기화블럭
		System.out.println("static { }");
	}
	
	{			//인스턴스 초기화 블럭
		System.out.println("{ }");
	}

	public BlockTest() {
		System.out.println("생성자");
	}

	public static void main(String args[]) {
		//클래스 초기화 블럭 
		
		
		BlockTest bt = new BlockTest();
		//인스턴스 생성 >> 인스턴스 초기화 블럭 >> 생성자
		
		BlockTest bt2 = new BlockTest();
		//인스턴스 생성 >> 인스턴스 초기화 블럭 >> 생성자
	}
}
