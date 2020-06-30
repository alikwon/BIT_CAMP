package cp6_0416;

public class Number {
	int num;
	
//	//생성자 
//	Number(){
//		System.out.println("생성자 호출");
//		num=1000;
//	}
	Number(int n){
		System.out.println("생성자 호출");
		num=n;
	}
	
	public static void main(String[] args) {
		//인스턴스 생성
		Number n1 =new Number(100);
		
		System.out.println(n1.num);
		
	}
}
