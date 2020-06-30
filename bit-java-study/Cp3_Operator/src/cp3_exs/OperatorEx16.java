package cp3_exs;

public class OperatorEx16 {

	public static void main(String[] args) {
		char lowerCase = 'a';
		char upperCase = (char)(lowerCase - 32);
		// 'a'의 유니코드 값에서 32를 빼면 'A'의 유니코드 값
		System.out.println(upperCase); //'A'출력

	}

}
