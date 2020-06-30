package cp5_homework;

//	문제3
//	원의 반지름 정보를 전달하면,
//	원의 넓이를 계산해서 반환하는 메서드와 
//	원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고,
//	이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)
public class Ex3 {
	
//	final double pi = 3.141592;
	double a;
	
	public Ex3(double a) {
		this.a=a;
	}
	double circleArea() {
		
		double area = Math.PI*a*a; //Math이용
		area = Math.floor(area); //버림
		area = Math.ceil(area);	//올림
		area = Math.round(area);//반올림
		return area;
	}
	
	double circleRound() {
		double round = 2*Math.PI*a;
		
		return round;
	}
	
	public static void main(String[] args) {
		Ex3 ex=new Ex3(2);
		
		System.out.println("넓이: "+ex.circleArea()+"둘레: "+ex.circleRound());
		
	}
}