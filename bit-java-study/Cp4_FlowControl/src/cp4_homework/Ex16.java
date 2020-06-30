package cp4_homework;

public class Ex16 {

	public static void main(String[] args) {
//		1 부터 99까지의 합을 구하는 프로그램 작성
//		while문, for문, do while 문을 각각 사용
		
		//while 사용
		int num=0,sum=0;
		while(num<100) {
			sum+=num;
			num++;
		}
		System.out.println(sum);
		
//		//for 사용
//		int sum = 0;
//		for (int num=0;num<100;num++) {
//			sum +=num;
//			}
//		System.out.println(sum);
//		
//		//do while 사용
//		int num=0,sum=0;
//		do {
//			sum+=num;
//			num++;
//		}while (num<100);
//		System.out.println(sum);
	}

}
