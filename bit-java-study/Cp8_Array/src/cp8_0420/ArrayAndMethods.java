package cp8_0420;

public class ArrayAndMethods {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 }; // 선언과 동시에 초기화
		int[] ref;
		ref = addAllArray(arr, 10);
		
		// 주소값 비교 ==> 0x100
		System.out.println("동일 배열 참조 : "+(arr==ref));
		
		for (int i = 0; i < ref.length; i++)
			System.out.print(arr[i] + " ");

	}

	// 배열(참조변수)을 전달 받아, 증가시킬 정수값도 받아서
	// 모든 배열의 요소에 더해준다.
	// 전달 받은 배열을 반환한다.
	public static int[] addAllArray(int[] ar, int addVal) {
		// int[]ar = 0x100 주소값

		for (int i = 0; i < ar.length; i++)
			ar[i] += addVal;
		return ar;
	}
}
