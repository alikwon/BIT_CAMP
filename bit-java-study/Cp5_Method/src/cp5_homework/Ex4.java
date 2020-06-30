package cp5_homework;

//문제4.
//전달되는 값이 소수(prime number)인지 아닌지를 판단하여,
//소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고,
//이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.

// 1부터 자기자신까지 나눠서 나머지가 0이 되는경우 count++
// count =2 일 때 true반환
public class Ex4 {

	static boolean primeNum(int a) {
		int count = 0;
		boolean prime = false;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0) {
				count += 1;
			}
		}
		if (count == 2) {
			prime = true;
		}
		return prime;
	}

//	for(int i = 1;i<=11;i++){
//		int count=0;
//		for(int j=1; j<=i; j++) {
//	
//			if (i%j==0) {
//				count = count+1;
//			}
//		}
//		if (count==2) {
//			System.out.println(i);
//		}
//	}
	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			if (primeNum(i))
				System.out.println(i);
		}
	}
}