package cp6_homework;

//문제1.
//밑변과 높이 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//끝으로 밑변과 높이 정보를 변경시킬 수 있는 메서드와 
//삼각형의 넓이를 계산해서 반환하는 메서드도 함께 정의하자.
public class TriangleMy {
	int width;
	int height;
	
	//생성자
	TriangleMy(int width, int height) {
		this.height=height;
		this.width=width;
	}
	
	//밑변, 높이 정보 메서드
	void data(int width, int height) {
		this.height=height;
		this.width=width;
	}
	
	//넓이 계산 메서드
	float area() {
		float area = width*height/2f;
		return area;
	}
	
	
	public static void main(String[] args) {
		TriangleMy ex = new TriangleMy(1,2);
		System.out.println(ex.area());
		ex.data(1,3);
		System.out.println(ex.area());
	}
}
