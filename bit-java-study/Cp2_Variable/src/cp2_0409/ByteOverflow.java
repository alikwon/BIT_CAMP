package cp2_0409;

public class ByteOverflow {

	public static void main(String[] args) {
		
		byte b = 0; //변수 선언 및 초기화
		int i = 0; //변수 선언 및 초기화
		
		for(int x = 0; x < 270; x++) 
			{
			//++ : 1씩증가하는 증감연산자
			
			System.out.print(b++); // b값 먼저 출력 후 ++
			System.out.print('\t'); //tab
			System.out.println(i++); //i값 출력후 ++
			}
	}

}
