package cp2_0409;

public class SpecialChar {

	public static void main(String[] args) {
		
		char single = '\''; 	
		// 따옴표출력 = \'  ,single = '''; 는 안됨
		
		String dblQuote = "\"Hello\""; 
		// 겹따옴표 출력 = \"
		
		String root = "c:\\"; 
		// 역슬래시 출력 = \\
		
		System.out.println(single);
		System.out.println(dblQuote);
		System.out.println(root);

	}

}
