package cp4_homework2;

public class Ex7 {

	public static void main(String[] args) {
//		[7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를완성하라. (1)에 알맞은 코드를 넣으시오.
//		[연습문제]/ch4/Exercise4_7.java

//		int value = ( /* (1) */ );
//		System.out.println("value:"+value);

		int value = (int) (Math.random() * 6 + 1);
		System.out.println("value:" + value);
		//Math.random() ⇒ 0.0<= x < 1.0  무작위 double형 숫자
	}

}
