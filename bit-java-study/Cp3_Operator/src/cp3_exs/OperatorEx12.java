package cp3_exs;

public class OperatorEx12 {

	public static void main(String[] args){
		int a = 1000000 * 100000 / 1000000;	// 곱셈부터 연산하므로 범위 벗어남
		int b = 1000000 / 100000 * 1000000;	// 나눗셈부터 연산해서 범위 벗어나지 않음

		System.out.println(a);				// 왜곡된 값
		System.out.println(b);				// 1 * 1000000
	}
}