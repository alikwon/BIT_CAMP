package cp8_0420;

public class ArrayEx4 {

	public static void main(String[] args) {
		// 정수 45개를 저장할수 있는 배열 생성
		int[] ball = new int[45];

		// 각 배열의 요소에 1~45숫자를 초기화 >>반복
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}

//		//1~45 초기화 됐는지 확인
//		for(int i=0; i< ball.length;i++) {
//			System.out.println(ball[i]);
//		}
//		for (int i=0; i < 5; i++) 
//			System.out.println(ball[i]);

		int temp;
		
		//랜덤한 index값 : 1~44 >> 0자리는 굳이 안바껴도됨
		//j를 밖에 생성해서 최적화(?)
		int j = 0;
		for (int i=0; i<10000;i++) {
			j = (int)(Math.random()*44)+1; //1~44
			temp = ball[0]; // 0번지 고정
			ball[0] = ball[j];
			ball[j] = temp;
			
		}

		for (int i=0; i < 6; i++) 
			System.out.print(ball[i]+" ");
	}
}
