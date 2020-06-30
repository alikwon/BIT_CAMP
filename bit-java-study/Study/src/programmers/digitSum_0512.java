package programmers;

public class digitSum_0512 {
	public static int solution(int n) {
        int answer = 0;
        while(n > 0) {
        	answer = answer + n%10;
        	n /=10;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
	public static void main(String[] args) {
		
		int n= 987;
		solution(n);
	}
}
