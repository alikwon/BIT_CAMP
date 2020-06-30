package programmers;

public class divisorSum_0512 {
	// 정수 n을 입력받아 n의 약수를 모두 더한값을 리턴
	// n은 0~3000
	
	// 절반까지 더하고 마지막에 n을 더해줌 // 오오오//
	public static int solution(int n) {
		int answer = 0;
		for (int i=1; i <= n/2 ; i++) {
			if (n%i==0) {
				answer += i;
			}
		}
		return answer+n;
	}
	public static void main(String[] args) {
		int n = 12;
		System.out.println(solution(n));
		
	}
}
