package cp2_0409;

public class StringTest {

	public static void main(String[] args) {
		double dd = 1d; 
		String a = 7 + " "; // 7뒤에 띄어쓰기
		String b = " " + 7; // 7앞에 띄어쓰기
		String c = 7 + "";  // 7뒤 공백
		String d = "" + 7;	// 7앞 공백
		String e = "" + "";	// 그냥 공백
		String f = 7 + 7 + ""; // (+)연산 후에 문자열
		String g = "" + 7 + 7; // 문자열로 차례대로 묶임
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(dd);
		

	}

}
