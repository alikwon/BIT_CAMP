package cp4_homework;

public class Ex1_IfReit {

	public static void main(String[] args) {
		int num = 120;

//		if(num>0) {
//			if((num%2)==0)
//			System.out.println("양수이면서 짝수");
//		}
		if (num > 0 && num % 2 == 0) { // if를 한개만 사용
			System.out.println("양수이면서 짝수");
		}
	}

}
