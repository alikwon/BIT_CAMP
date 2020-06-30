package cp4_0413;

public class Ex1 {

	public static void main(String[] args) {
		// 1~10 까지의 합
		// +1씩 10번 반복
		
		//for 사용
		int sum = 0; 	// 연산의 합을 담는 변수

		for (int i = 1; i <= 10; i++) {	//10번 연산이 이루어짐
			// System.out.println(i);
			sum += i; 	// 순차적으로 합을 구할 수 있다
		}
		System.out.println("1부터 10까지의 합은 : " + sum);
		
		//while 사용
		int i = 1;
		sum = 0;		//재할당
		
		while(i <= 10) {
			// System.out.println(i);
			sum += i;
			i++;
		}
		System.out.println("1부터 10까지의 합은 : " + sum);
	}

}
