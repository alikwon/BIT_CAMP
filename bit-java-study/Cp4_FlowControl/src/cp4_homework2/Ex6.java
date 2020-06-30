package cp4_homework2;

public class Ex6 {
	public static void main(String[] args) {
//		[6] 두 개의 주사위를 던졌을 때, 
//		눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을작성하시오.
		for (int num1=1; num1<=6;num1++) {
			for(int num2=1; num2<=6; num2++) {
				if (num1+num2== 6)
					System.out.println
					("주사위1의 눈 : "+num1+"  주사위2의 눈 : "+num2);
			}
		}
	}

}
