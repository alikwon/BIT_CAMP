package cp4_0413;

public class CondOP {

	public static void main(String[] args) {
		// 숫자 2개를 받음
		int num1 = 100, num2 = 50;

		// 큰수, 차이값을 저장하는 변수(일괄적으로 출력하기 위해서)
		int bigNum, diffNum; // 큰수 , 차이값

		bigNum = (num1 > num2) ? num1 : num2;
		// 조건이 참이면num1, 거짓이면num2

		diffNum = (num1 > num2) ? num1 - num2 : num2 - num1;
		// 조건이 참이면 num1-num2, 거짓이면 num2-num1

		System.out.println("큰수 : " + bigNum + "\t두수의 차 : " + diffNum);
	}

}
