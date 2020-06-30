package cp3_exs;

public class OperatorEx14 {

	public static void main(String[] args) {
		
		char c1 = 'a';
		//char c2 = c1 + 1;	//int연산이라서 형변환을 해줘야함 (char)(c1+1) 
		char c2 = 'a' + 1; //리터럴 간의 연산이기 때문에 정상작동
		System.out.println(c2);
	}
} 