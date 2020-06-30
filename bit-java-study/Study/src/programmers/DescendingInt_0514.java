package programmers;


import java.util.Arrays;
import java.util.Collections;

/*
	n을 매개변수
	각자리숫자를 큰것부터 작은순으로 정렬
	118372 ==> 873211
	
	n = 8십억 이하의 자연수
 */
public class DescendingInt_0514 {

	public static long solution(long n) {
		long answer = 0;
		String [] array = (""+n).split("");
		Arrays.sort(array, Collections.reverseOrder());
		for(int i =0; i< array.length;i++) {
			answer *= 10;
			answer += Integer.parseInt(array[i]);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		long n = 7896541234L;
		System.out.println(solution(n));
		
	}

}
