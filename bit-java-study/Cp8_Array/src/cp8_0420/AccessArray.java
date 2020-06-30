package cp8_0420;

public class AccessArray {

	public static void main(String[] args) {
		//int 타입의 정수 데이터 3개를 저장할 수 있는 배열 생성
		//배열의 이름 arr
		//배열선언
		int[] arr;
		
		//배열 인스턴스 생성: 각 요소의 저장공간 생성
		arr= new int[3];
		
		//배열 요소에 참조 : 인덱스 값이 벗어나면 오류발생
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
//		for (int i =0; i<arr.length; i++) 
//			{ arr[i]=i+1; }
		
		int sum = arr[0] + arr[1] + arr[2];
		System.out.println(sum);
	}
}
