package cp4_homework;

public class Ex9 {

	public static void main(String[] args) {
		//for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
		
		int gob = 1;
		for (int i = 1; i <= 10; i++) {
			gob = gob * i;
		}
		System.out.println(gob);
	}

}
