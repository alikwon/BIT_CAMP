package cp2_0409;

public class PrecisionTest {

	public static void main(String[] args) {
		
		float f = 1.2345678901234567890f; //float형 접미사 'f'
		double d = 1.2345678901234567890; //890이 짤림
		float f2 = 0.100000001f; // 맨뒤에 1이 잘리므로 0.1출력
		double d2 = 0.100000001; // double 접미사 생략
		double d3 = 0.1000000000000001;
		
		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		System.out.println(d2);
		System.out.println(d3);  
	}

}
