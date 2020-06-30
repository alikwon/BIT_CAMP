//Short-Circuit Evaluation
package cp3_0410;

public class SCE { 

	public static void main(String[] args) {
		
		int num1=0, num2=0;						//변수 선언
		boolean result;
		
		result = (num1+=10)<0 && (num2+=10)>0;	// num1+=10 이 false이므로 
		System.out.println("result="+result);	// &&뒤의 num2+=10 연산은 안 됨
		System.out.println("num1="+num1+", num2="+num2); 
		//num1+=10 연산이 수행되었으므로 num1 = 10
		
		result = (num1+=10)>0 || (num2+=10)>0;	// num1+=10 이 true이므로 
		System.out.println("result="+result);	// ||뒤의 num2+=10 연산은 안 됨
		System.out.println("num1="+num1+", num2="+num2);
		//num1+=10 연산이 수행되었으므로 num1 = 20 (위에서 num1 = 10

	}

}
