package cp3_0410;

public class PrefixOp {

	public static void main(String[] args) {
		
		//변수선언
		int num1 = 7;   			// num1 = 7 
		int num2 = ++num1; 			// num2 = 8, num1 = 8  
		int num3 = --num1;			// num1 = 7, num2 = 8, num3 = 7
		
		System.out.println(++num1); // 출력: 8, num1 = 8, num2 = 8, num3 = 7
		// 전위형 : 1 증감 뒤 출력
		System.out.println(num2); 	// 출력 : 8, num2 = 8
		System.out.println(--num2); // 출력 : 7
		System.out.println(num3);	// 출력 : 7

	}

}
