package cp4_0413;

public class IEGrade {

	public static void main(String[] args) {

		int score = 93;

		String grade = ""; 	// 문자열 초기화
							// A+, A, A-, B+, B, B-,C

		// 100~98=A+, 97~94=A, 93~90=A-
		if (score >= 90) {
			grade = "A";

			if (score >= 98) { 		// 98보다 큰점수
				grade += "+"; 		// "A"에 "+" 붙음
			} else if (score < 94) {// 90 <= score < 94
				grade += "-";		// "A"에 "-" 붙음
			}
		} else if (score >= 80) { 	// 80 <= score < 90
			grade = "B"; 			// 위의 if가 참일시 안돔

			if (score >= 88) {
				grade += "+";
			} else if (score < 84) {
				grade += "-";
			}
		} else { 					// 나머지 = 80 < score
			grade = "C";
		}

		System.out.println(grade);

		// if (score >= 98 && score <= 100 ) {
//			grade = "A+";		
//		}
//		if (score >= 94 && score <= 97 ) {	
//			grade = "A";		
//		}
//		if (score >= 93 && score <= 90 ) {	
//			grade = "A-";		
//		}
	}

}
