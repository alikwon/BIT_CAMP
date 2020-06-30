package cp3_exs;

public class OperatorEx2 {

	public static void main(String[] args) {
		int i=5;				//변수 선언
		int j=0;				
		j = i++;				//j에 i먼저 대입 후 i + 1
		
		System.out.println		//j = 5 , i = 6
		("j=i++; 실행 후, i=" + i +", j="+ j);
		
		i=5;					// 결과를 비교하기 위해, i와 j의 값을 다시 5와 0으로 변경
		j=0;
		j = ++i;				//i + 1 후에 j에 i대입
		
		System.out.println		//j = 6 , i = 6
		("j=++i; 실행 후, i=" + i +", j="+ j);

	}

}
