package cp4_homework2;

public class Ex4 {
	public static void main(String[] args) {
//		[4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때
//		몇까지 더해야 총합이 100이상이되는지 구하시오.
		
		int num = 0, sum = 0;

		while (true) {
			num++;
			if (num % 2 == 1) {
				sum += num;
			} else {
				sum -= num;
			}
			if (sum >= 100)
				break;
		}

	}
}
