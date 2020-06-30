package cp4_0413;

public class IEUsage {

	public static void main(String[] args) {
		int num = 10;

		// 양수 판별 = 양수일때 "양수 입니다"
		if (num > 0) {
			System.out.println("양수 입니다");
		} // 하나만 처리할 경우 else없이 if만

		// 홀,짝수 판별 = num%2==0 짝수
		if (num % 2 == 0) {
			System.out.println("짝수 입니다");
		} else {
			System.out.println("홀수 입니다");
		} // 판별식을 잘 구성하는 것이 중요
	}
}
