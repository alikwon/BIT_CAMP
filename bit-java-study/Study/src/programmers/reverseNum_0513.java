package programmers;

public class reverseNum_0513 {

	public static void main(String[] args) {
		long n = 123456789012L;
		int[] answer = {};

		// 1)
		int length = (int) (Math.log10(n) + 1);
		System.out.println(length);
		answer = new int[length];
		for (int i = 0; i < answer.length; i++) {
			long s = n % 10;
			answer[i] = (int) s;
			n /= 10;
		}

		// 2) 스트링 버퍼 reverse() 사용
		String str = String.valueOf(n);
		StringBuffer sb = new StringBuffer(str);
		sb = sb.reverse();
		String[] str_re = sb.toString().split("");
		answer = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			answer[i] = Integer.parseInt(str_re[i]);
		}

		// 3) 간단한 방법
		String a = "" + n; // 간단한건데 생각을 못했음...
		answer = new int[a.length()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = (int) (n % 10);
			n /= 10;
		}

//        // 출력
//        System.out.print("[");
//		for (int i = 0; i < answer.length; i++) {
//			System.out.print(answer[i]+",");
//		}
//        System.out.println("]");
	}
}
