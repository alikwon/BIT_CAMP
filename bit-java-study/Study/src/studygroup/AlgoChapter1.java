package studygroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlgoChapter1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AlgoChapter1 ag = new AlgoChapter1();
		ag.printSpira();
		sc.close();
	}

	void calcMaxOrMin() {
		System.out.println("1번째 숫자 입력 : ");
		int a = sc.nextInt();
		System.out.println("2번째 숫자 입력 : ");
		int b = sc.nextInt();
		System.out.println("3번째 숫자 입력 : ");
		int c = sc.nextInt();
		System.out.println("4번째 숫자 입력 : ");
		int d = sc.nextInt();
		System.out.println("[1]최대값구하기\t[2]최소값구하기>>>");
		int choice = sc.nextInt();
		if (choice == 1) {
			int result = max4(a, b, c, d);
			System.out.println("최대값은 " + result + "입니다.");
		} else if (choice == 2) {
			int result = min4(a, b, c, d);
			System.out.println("최소값은 " + result + "입니다.");
		} else {
			System.out.println("잘못된 입력");
		}
	}

	void calcMin() {
		System.out.println("1번째 숫자 입력 : ");
		int a = sc.nextInt();
		System.out.println("2번째 숫자 입력 : ");
		int b = sc.nextInt();
		System.out.println("3첫번째 숫자 입력 : ");
		int c = sc.nextInt();

		int result = min3(a, b, c);
		System.out.println("최소값은 " + result + "입니다");

	}

	// 4개 값중 최대값
	int max4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[numList.length - 1];
	}

	// 4개 값중 최소값
	int min4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[0];
	}

	// 3개 값중 최소값
	int min3(int a, int b, int c) {
		int[] numList = { a, b, c };
		int min = numList[0];
		for (int i = 1; i < numList.length; i++) {
			if (min > numList[i]) {
				min = numList[i];
			}
		}
		return min;
	}

	// Q6
	void sumWhile() {
		System.out.println("1부터 n까지의 합을 구합니다");
		System.out.println("n의 값 : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println("i : " + i);
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다");
	}

	// Q7
	void calcSum() {
		System.out.println("숫자입력 : ");
		int a = sc.nextInt();
		int result = 0;
		for (int i = a; i > 0; i--) {
			result += i;
		}
		System.out.println(result);
	}

	// Q8
	void calcSum2() {
		System.out.println("숫자입력하세요 : ");
		int a = sc.nextInt();
		int sum = (1 + a) * a / 2;
		System.out.println(sum);
	}

	// Q9
	void calcSum3() {
		System.out.println("a 입력 : ");
		int a = sc.nextInt();
		System.out.println("b 입력 : ");
		int b = sc.nextInt();
		int sum = 0;
		if (a <= b)
			sum = (a + b) * (b - a + 1) / 2;
		else
			sum = (a + b) * (a - b + 1) / 2;
		System.out.println("a와 b사이 정수의 합 : " + sum);
	}

	// Q10
	void subBA() {
		System.out.println("a 입력 : ");
		int a = sc.nextInt();
		while (true) {
			System.out.println("b 입력 : ");
			int b = sc.nextInt();
			if (b <= a) {
				System.out.println("b값은 a값보다 커야합니다");
				continue;
			} else {
				int result = b - a;
				System.out.println("b-a는 " + result + "입니다");
				break;
			}
		}
	}

	// Q11
	// 양의 정수를 입력하고 자릿수를 출력
	void digitOfNum() {
		while (true) {
			System.out.print("숫자 입력>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("양의 정수를 입력하세요");
				continue;
			}
			int result = 0;
			while (true) {
				a /= 10;
				result++;
				if (a == 0) {
					System.out.println("a는 " + result + "자리 숫자임");
					break;
				}
			}
			break;
		}

	}

	// Q12
	// 곱셈표 출력
	void gugudanTable() {
		System.out.println(" │1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("─┼────────────────────────────────────────────────────────────────");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "│");
			for (int j = 1; j < 10; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
	}

	// Q13
	// 덧셈표 출력
	void plusTable() {
		System.out.println(" │1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("─┼────────────────────────────────────────────────────────────────");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "│");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + j + "\t");
			}
			System.out.println();
		}
	}

	// Q14
	// 입력한수를 한변으로 하는 정사각형을 * 기호로
	void printSquare() {
		while (true) {
			System.out.println("단 수를 입력하세요>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("0보다 커야합니다. 다시입력하세요");
				continue;
			}
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
	}

	// Q15
	// 직각 이등변 삼각형출력
	void printTriangle() {
		while (true) {
			System.out.println("몇 단 삼각형인가요 ?>>>");
			int n = sc.nextInt();
			if (n <= 1) {
				System.out.println("1보다 큰수를 입력하세요!");
				continue;
			}
			System.out.println("직각인 부분은 어디인가요");
			System.out.println("[1]왼아래  [2]왼위  [3]오른아래  [4]오른위");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				triangleLB(n);
				break;
			case 2:
				triangleLU(n);
				break;
			case 3:
				triangleRB(n);
				break;
			case 4:
				triangleRU(n);
				break;
			default:
				break;
			}
			break;
		}

	}

	// 오른위
	void triangleRU(int n) {
		System.out.println("오른쪽 위가 직각인 이등변 삼각형을 출력합니다");
		int a = 0;
		for (int i = n; i >= 1; i--) {
			a = n - i;
			while (a > 0) {
				System.out.print(" ");
				a--;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 오른아래
	void triangleRB(int n) {
		System.out.println("오른쪽 아래가 직각인 이등변 삼각형을 출력합니다");
		int a = 0;
		for (int i = 1; i <= n; i++) {
			a = n - i;
			while (a > 0) {
				System.out.print(" ");
				a--;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 왼위
	void triangleLU(int n) {
		System.out.println("왼쪽 위가 직각인 이등변 삼각형을 출력합니다");
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 왼아래
	void triangleLB(int n) {
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Q16
	// n단의 피라미드
	void printSpira() {
		int n=0;
		int space=0;
		while(true) {
			System.out.println("몇 단 피라미드 인가요?>>");
			int a = sc.nextInt();
			
			System.out.println("[1]숫자로 출력   [2]*모양으로 출력");
			int choice= sc.nextInt();
			if(choice==1) {
				for (int i = 1; i <= a; i++) {
					space=a-i;
					n= (i-1)*2+1;
					while(space>0) {
						System.out.print(" ");
						space--;
					}
					for (int j = 1; j <= i; j++) {
						while(n>0) {
							System.out.print(i%10);
							n--;
						}
					}
					System.out.println();
				}
			}else if(choice==2) {
				for (int i = 1; i <= a; i++) {
					space=a-i;
					n= (i-1)*2+1;
					while(space>0) {
						System.out.print(" ");
						space--;
					}
					for (int j = 1; j <= i; j++) {
						while(n>0) {
							System.out.print("*");
							n--;
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

}
