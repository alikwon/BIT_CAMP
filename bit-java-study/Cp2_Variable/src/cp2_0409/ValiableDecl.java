package cp2_0409;

public class ValiableDecl {

	public static void main(String[] args) {
		
		double num1,num2,result; //double형 변수 선언
		//안쓰면 오류
		
		num1 = 1.0000001; //num1 초기화
		num2 = 2.0000001; //num2 초기화
		
		result = num1 + num2; //result에 num1+ num2 값을 저장
		//result = num1 * num2;
		
		System.out.println(num1); //num1 출력
		System.out.println(num2); //num2 출력
		System.out.println(result); //result 출력
		
		double num3 = num1 * 10000000;  
		double num4 = num2 * 10000000;
		double result1 = num3 + num4;
		System.out.println(result1/10000000);  //부동소수점문제 해결법 중 하나
		}

}
