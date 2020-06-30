package cp4_0413;

public class DupFor {

	public static void main(String[] args) {
		
		//i가 0부터 2까지 반복
		for (int i = 0; i < 3; i++) { 
			//i값 출력
			System.out.println("변수 i의 값: " + i); 
			//i값 출력후 j가 0부터 2까지 반복
			for (int j = 0; j < 3; j++)	
				//j값 출력
				System.out.println("***변수 j의 값: " + j); 
		}
	}

}
