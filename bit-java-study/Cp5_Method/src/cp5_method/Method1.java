package cp5_method;

public class Method1 {
	public static void main(String[] args) {
		
	
		//메서드를 사용하기 위해서는 인스턴스(객체)
		//메서드 코드를 메모리에 로드한다
		//인스턴스 생성(객체 생성)=new
		MyMath math = new MyMath(); 
		long result = math.add(10, 100);
		
		System.out.println(result);
		System.out.println(math.add(10000000000L, 20000000000L));
		
	}
		
	int add() {
		return 10;
	}

}
