package studygroup;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter2 {
	static Scanner sc = new Scanner(System.in);


	// Q1
	// 사람수도 난수로...
	void MaxOf() {
		Random rand = new Random();
		int p = 1 + rand.nextInt(11);
		System.out.println("키의 최대값을 구합니다");
		System.out.println("사람수 >>>" + p + "명");

		int[] height = new int[p];
		System.out.println("키값은 다음과 같습니다");
		for (int i = 0; i < p; i++) {
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "]" + height[i]);
		}
		int max = height[0];
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
			}
		}
		System.out.println("최대값은 " + max + "입니다");
	}

	// Q2
	// 배열요소를 역순으로 정렬
	void reverseArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		print(arr);
		for (int i = 0; i < arr.length / 2; i++) {
			System.out.println("arr[" + i + "]과 arr[" + (arr.length - i - 1) + "]을 교환합니다");
			changePositon(arr, i, arr.length - i - 1);
			print(arr);
		}
		System.out.println("역순정렬을 마쳤습니다.");
	}
	
	void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	void changePositon(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// Q3
	// 배열의 모든요소의 합을 구하는 메서드
	void sumOfArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		System.out.println("배열모든요소의 합은 " + result + "입니다.");
	}

	//Q4
	//배열b의 모든요소를 배열a에 복사하는 메서드
	void copyArr() {
		int[]a= {1,2,3,4,5,6};
		int[]b= {};
//		int[]b=Arrays.copyOf(a, a.length);
		System.out.println("배열 a를 b로 복사합니다");
		System.out.print("원래의 b\n" );
		print(b);
		b=a.clone();
		System.out.println("[복사후 b]");
		print(b);
	}
	
	void copyArr2() {
		int[]a= {1,2,3,4,5,6};
		int[]b= new int[a.length];
		System.out.println("배열 a를 b로 복사합니다");
		System.out.print("[원래의 b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[i]=a[i];
		}
		System.out.println("[복사후 b]");
		print(b);
	}

	//Q5
	//이번엔 역순으로복사
	void rcopyArr() {
		int[]a= {1,2,3,4,5,6,7};
		int[]b=new int[a.length];
		System.out.println("배열 a를 b로 복사합니다");
		System.out.print("[원래의 b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[a.length-i-1]=a[i];
		}
		System.out.println("[복사후 b]");
		print(b);
		
	}
	
	//Q6
	//배열의 앞쪽에 아랫자리가 아니라 윗자리를 넣어두는 메서드
	void cardConv() {
		
	}
	
	//Q7
	//기수변환과정을 상세히 나타내는 메서드
	
	public static void main(String[] args) {
		AlgoChapter2 ag = new AlgoChapter2();
		ag.copyArr2();
		sc.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
