package cp6_homework;

//	문제1.
//	"밑변과 높이" 정보를 지정할 수 있는 Triangle 클래스를 정의하자.
//	끝으로 "밑변과 높이 정보를 변경"시킬 수 있는 메서드와 
//	"삼각형의 넓이를 계산해서 반환하는 메서드"도 함께 정의하자.
//	area= a*b/2
public class Triangle {
	
	int width;	//밑변
	int height;	//높이  >>> 변경 시켜야 하기때문에 값을 지정하지 않음
	
	//생성자 : 인스턴스 생성시 반드시 한번 실행 ==> 인스턴스 변수 초기화 작업
	//		생략 가능 (default Constructor)
	//변수 < 생성자 < 매서드 (암묵적인 약속)
	
	//기본 생성자 : 클래스이름 ==> 명시적으로 구성★
	Triangle(int w, int h){	//setData와 같은 역할
		width=w;
		height=h;
	}
	
	//밑변과 높이 데이터를 변경하는 메서드
	void setData(int w, int h) {
		width = w;
		height = h;
	}
	
	//넓이를 구해서 반환
	float calcArea() {
		float area= (width*height)/2f;
		return area;
	}
	
	public static void main(String[] args) {
//		Triangle t = new Triangle();
		Triangle t = new Triangle(5,5);
		
//		t.setData(5, 5);
		System.out.println("삼각형 밑변 : "+t.width+", 높이 : "+t.height);
		System.out.println("넓이 : "+t.calcArea());
	}
}
