package cp3_exs;

public class OperatorEx4 {

	public static void main(String[] args) {
		int i = -10; 			//변수 선언
		i = +i;					
		
		System.out.println(i);	// +(-10) = -10
		
		i = -10;			
		i = -i;
		System.out.println(i);	//-(-10) = 10		

	}

}
