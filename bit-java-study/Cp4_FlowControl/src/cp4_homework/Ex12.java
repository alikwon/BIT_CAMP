package cp4_homework;

public class Ex12 {

	public static void main(String[] args) {
		// 자연수 1부터 시작해서 모든 홀수와 3의 배수인 짝수를 더해 나간다
		// 그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지
		// 그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
		// 프로그램 내부에 while문을 무한 루프로 구성하여 작성

		//자연수 1부터, 합, 더한횟수 변수로 선언
		int num = 1, sum = 0, count = 0;
		
		//무한 루프
		while (true) {
			// 3의 배수중 짝수(6의배수)이거나 홀수일 때 실행
			if (num % 2 != 0 || (num % 3 == 0 && num % 2 == 0)) {
				sum += num;	// 조건에 만족한 num 값을 더함
				count++;	// 더한 횟수를 올려줌
				// System.out.println(num +"\t"+sum+"\t"+count);
			}
			if (sum > 1000) {	// 더한 값이 1000이 넘었을때 실행
				System.out.println("더한 횟수 : " + count); 
				System.out.println("1000을 넘은 값 : " + sum);
				break; //while 탈출
			}
			num++;//num을 1씩 계속 증가시켜줌

		}
		System.out.println(sum);
	}
}
