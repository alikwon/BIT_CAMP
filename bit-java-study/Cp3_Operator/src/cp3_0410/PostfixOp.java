package cp3_0410;

public class PostfixOp {

	public static void main(String[] args) {
		
		//변수선언
		int num1 = 7;   			// num1 = 7
		int num2 = num1++; 			// num2 = 7, num1 = 8 
		int num3 = num1--;			// num2 = 7, num3 = 8, num1 = 7
		
		System.out.println(num1++); // 출력 : 7, num1 = 8, num2 = 7, num3 = 8
		// 후위형 : 출력한 뒤 1 증감
		System.out.println(num2); 	// 출력 : 7, num2 = 7
		System.out.println(num2--); // 출력 : 7, num2 = 6
		System.out.println(num3);	// 출력 : 8

	}

}
