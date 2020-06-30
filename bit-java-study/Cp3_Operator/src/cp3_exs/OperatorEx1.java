package cp3_exs;

public class OperatorEx1 {

	public static void main(String[] args) {
		int i=5;				// 변수 선언
		i++;					// i=i+1; 과 같은 의미
								
		System.out.println(i);	// 6 출력
		i=5;					// 결과를 비교하기 위해 i값을 다시 5로 변경
		++i;					// ++i; 로 바꿔 써도 위와 같은 결과
		System.out.println(i);	// 6 출력
	}

}
