package studygroup;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter3 {
	static Scanner sc = new Scanner(System.in);

	// 선형검색
	int seqSearch(int[] a, int n, int key) {
		int i = 0;

		// 선형검색 while
//		while(true) {
//			if(i==n){
//				return -1;
//			}
//			if(a[i]==key)
//				return i;
//			i++;
//		}

		// 선형검색 for
		for (int j = 0; j < n; j++) {
			if (a[j] == key)
				return i;
		}
		return -1;
	}

	void doSearch() {
		System.out.println("요소의 개수: ");
		int num = sc.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("검색할 값 : ");
		int ky = sc.nextInt();
		int idx = seqSearch(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
	}

	// 선형검색 (보초법) sentinel
	// if 문이 전과 비교해서 하나만 사용
	// ==> 반복종료에 대한 판단횟수가 실제로 절반으로 줄어듦
	int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		while (true) {
			if (a[i] == key)
				break;
			i++;
		}
		return i == n ? -1 : i;
	}

	void doSearchSen() {
		System.out.println("요소의 개수: ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("검색할 값 : ");
		int ky = sc.nextInt();
		int idx = printSearch(x, num, ky);

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
	}

	// Q1
	// seqSearchSen()의 while문을 for문으로 바꾸기
	int seqSearchSen2(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		for (int j = 0; j < n; j++) {
			if (a[j] == key) {
				i = j;
				break;
			}
		}
		return i == n ? -1 : i;
	}

	int seqSearchSen3(int[] a, int n, int key) {
		int i;
		a[n] = key; // 보초를 추가
		for (i = 0; a[i] != key; i++);
		return i == n ? -1 : i;
	}

	// Q2
	int printSearch(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[i] == key)
				return i; // 검색성공
		}
		return -1; // 검색실패
	}
	
	//Q3
	void searchIdx() {
		System.out.print("요솟수：");
		int num = sc.nextInt();
		int[] x = new int[num]; // 요솟수 num인 배열
		int[] y = new int[num]; // 요솟수 num인 배열

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = sc.nextInt();
		}
		System.out.print("찾는 값："); // 키 값을 입력 받음
		int ky = sc.nextInt();

		int count = 0;
		for (int i = 0; i < num; i++) {
			if (x[i] == ky)
				y[count++] = i;
		}

		if (count == 0)
			System.out.println("그 값의 요소가 없습니다.");
		else
			for (int i = 0; i < count; i++) {
				System.out.println("그 값은 " + "x[" + y[i] + "]에 있습니다.");
			}
		System.out.println(y.length);
	}
	
	//Q4
	//이진 검색과정 출력
	void printBinSearch() {
		System.out.print("요솟수：");
		int num = sc.nextInt();
		int[] x = new int[num]; // 요솟수 num인 배열

		System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0]："); // 맨 앞 요소를 읽어 들임
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = sc.nextInt();
			} while (x[i] < x[i - 1]); // 하나 앞의 요소보다 작으면 다시 입력
		}

		System.out.print("찾는 값："); // 키 값을 입력 받음
		int ky = sc.nextInt();

		int idx = binSearchEx(x, num, ky); // 배열 x에서 값이 ky인 요소를 검색

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky + "은 x[" + idx + "]에 있습니다.");
	}
	private int binSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		int pl = 0; // 검색범위 맨 앞의 index
		int pr = n - 1; // 검색범위 맨 뒤의 index

		do {
			int pc = (pl + pr) / 2; // 중앙요소의 index
			System.out.print("   |");
			if (pl != pc)
				System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
			else
				System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
			if (pc != pr)
				System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
			else
				System.out.println("->");
			System.out.printf("%3d|", pc);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[pc] == key)
				return pc; // 검색성공
			else if (a[pc] < key)
				pl = pc + 1; // 검색범위를 뒤쪽 절반으로 좁힘
			else
				pr = pc - 1; // 검색범위를 앞쪽 절반으로 좁힘
		} while (pl <= pr);
		return -1;
	}

	public static void main(String[] args) {
		AlgoChapter3 ag = new AlgoChapter3();
		ag.printBinSearch();
		sc.close();
	}
}
