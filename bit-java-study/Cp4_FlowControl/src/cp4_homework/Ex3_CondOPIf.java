package cp4_homework;

public class Ex3_CondOPIf {

	public static void main(String[] args) {
		// 숫자 2개를 받음
		int num1 = 50, num2 = 100;
		// 큰수, 차이값을 저장하는 변수(일괄적으로 출력하기 위해서)
		int bigNum, diffNum;

		// 조건이 참이면num1, 거짓이면num2
		if (num1 > num2) {
			bigNum = num1;
		} else {
			bigNum = num2;
		}

		// 조건이 참이면 num1-num2, 거짓이면 num2-num1
		if (num1 > num2) {
			diffNum = num1 - num2;
		} else {
			diffNum = num2 - num1;
		}
		System.out.println("큰 값 : " + bigNum + "  두 수의 차 : " + diffNum);

	}

}
