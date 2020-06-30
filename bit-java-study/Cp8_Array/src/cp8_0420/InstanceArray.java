package cp8_0420;

public class InstanceArray {

	public static void main(String[] args) {
		//참조형 변수 : 각각 String 타입의 인스턴스를 가리키는 주소값이 들어감
		String[] strArr = new String[3];
		
		strArr[0] = new String("Java");//"Java"의 주소값이 strArr[0]에 들어감
		strArr[1] = "JS";
		strArr[2] = "Python";
		
		System.out.println(strArr[0].length()); //strArr의 length 출력
		System.out.println(strArr[0].toString());
		
		//배열의 순차적 참조 : for문을 이용해 순차적 참조가능
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
			
	}

}
