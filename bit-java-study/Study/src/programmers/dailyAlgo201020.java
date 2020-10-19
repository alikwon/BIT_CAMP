package programmers;

import java.util.Scanner;

public class dailyAlgo201020 {
	Scanner sc = new Scanner(System.in);

//	● 직사각형 별찍기
//	- 문제 설명 
//		이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다. 
//		별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
//	
//	- 제한 조건 
//		n과 m은 각각 1000 이하인 자연수입니다.
	public void solution1() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

//	● x만큼 간격이 있는 n개의 숫자
//	 - 문제 설명 
//		함수 solution은 정수 x와 자연수 n을 입력 받아, 
//		x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야합니다. 
//		다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
//	  
//	- 제한 조건 
//		x는 10000000 이상, 10000000 이하인 정수입니다. 
//		n은 1000 이하인 자연수입니다.
	public long[] solution2(int x, int n) {
		long c = 0;
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			c += x;
			answer[i] = c;
		}
		return answer;
	}

	// 다른 풀이
	public long[] solution2_2(long x, int n) {
		long[] answer = new long[n];
		answer[0] = x;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] + x;
		}
		return answer;
	}

//	● 행렬의 덧셈
//	- 문제 설명
//		행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 
//		서로 더한 결과가 됩니다. 
//		2개의 행렬 arr1과 arr2를 입력받아, 
//		행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
//
//	- 제한 조건
//		행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
	public int[][] solution3(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}

//	
//	● 핸드폰 번호 가리기
//	- 문제설명
//		프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 
//		고객들의 전화번호의 일부를 가립니다.
//		전화번호가 문자열 phone_number로 주어졌을 때, 
//		전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, 
//		solution을 완성해주세요.
//
//	- 제한 조건
//		s는 길이 4 이상, 20이하인 문자열입니다.
	/*
	 * 1.전달받은 문자열길이(len) 2.표시할 숫자 --> 끝에서 4개의 문자(num) 3.별표시 반복횟수 (starNum=len-4)
	 */
	public String solution4(String pNum) {
		// pNum의 길이
		int len = pNum.length();
		// 숫자로 표시할 부분
		String num = pNum.substring(len - 4, len);
		// 별표로 바꿀 숫자 개수
		int starNum = pNum.substring(0, len - 4).length();
		// stars은 문자열 "*"를 몇번 반복할건지에 대한 변수
		String stars = new String(new char[starNum]).replace("\0", "*");
		return stars + num;
	}

	/*
	 * 다른풀이 1. (전달받은 문자열의 길이 -4)만큼 "*"을 반복 후 결과에 넣고 2. 뒤에 끝 4개 문자를 붙여줌
	 */
	public String solution4_2(String pNum) {
		String answer = "";
		int len = pNum.length();
		for (int i = 0; i < len - 4; i++) {
			answer += "*";
		}
		answer += pNum.substring(len - 4, len);
		return answer;
	}
	
	public String solution4_3(String pNum) {
		String answer = "";
		int len = pNum.length();
		answer = pNum.substring(0, len - 4).replaceAll(".", "*") + 
				pNum.substring(len - 4, len);
		return answer;
	}

	/*
	 * 다른사람 풀이
	 */
	public String solution4_4(String pNum) {
		char[] a = pNum.toCharArray();
		for (int i = 0; i < a.length - 4; i++) {
			a[i] = '*';
		}
		return String.valueOf(a);
	}


//	
//	● 히샤드수
//	- 문제설명
//		양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
//		예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
//		자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
//
//	- 제한 조건
//		x는 1 이상, 10000 이하인 정수입니다.
	public boolean solution5(int x) {
		int a = x;
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		return a % sum == 0 ? true : false;
	}

	public static void main(String[] args) {
		dailyAlgo201020 ag = new dailyAlgo201020();
		System.out.println(ag.solution5(10));
	}

}
