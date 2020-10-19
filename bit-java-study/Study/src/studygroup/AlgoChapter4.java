package studygroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AlgoChapter4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		AlgoChapter4 ag = new AlgoChapter4();
		ag.practice4_2();
		sc.close();
	}

	//Q1
	//실습 4-2를 제외하고 IntStack클레스의 메서드를 사용하는 프로그램 작성
	private void practice4_2() {
		IntStack is = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터수 : "+is.size()+"/"+is.capacity());
			System.out.println("[1]푸시 [2]팝 [3]피크 [4]뎀프 [5]인덱스오브 \n[6]클리어 [7]이즈엠프티 [8]이즈풀 [0]종료");
			
			int menu = sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch (menu) {
			case 1:	//푸쉬
				System.out.println("데이터: ");
				x=sc.nextInt();
				try {
					is.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득찼습니다");
				}
				break;
			case 2:	//팝
				try {
					x=is.pop();
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있어요");
				}
				break;
			case 3:	//피크
				try {
					x=is.peek();
					System.out.println("피크한 데이터는 "+x+"입니다");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있어요");
				}
				break;
			case 4: //덤프
				is.dump();
				break;
			case 5:	//인덱스오브
				try {
					System.out.println("찾을 숫자를 입력하세요>>>");
					int a = sc.nextInt();
					x=is.indexOf(a);
					if(x==-1) {
						System.out.println("입력값이 스택에 없어요");
					}else {
						System.out.println("입력값은 스택의 ["+x+"]번 index에 있습니다");
					}
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있어요");
				}
				break;
			case 6:
				is.clear();
				System.out.println("스택의 모든값이 삭제됐어요");
				break;
			case 7:
				if(is.isEmpty()) System.out.println("스택이 비어있습니다");
				else System.out.println("스택이 비어있지 않습니다");
				break;
			case 8:
				if(is.isFull()) System.out.println("스택이 가득찼습니다");
				else System.out.println("스택에 여유공간이 남아있어요");
			default:
				System.out.println("알맞은 항목을 선택하세요");
				break;
			}
		}
	}
	
	//Q2
	//임의의 객체형 데이터를 쌓을 수 있는 제네릭 스택클래스 Gstack<E> 를 작성하세요
	// 풀이 >>> Gstack 클래스 파일
	
	//Q3
	//하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스를 만드세요
	//스택에 저장하는 데이터는 int형 값, 배열의 처음과 끝을 사용
	// 풀이 >>> IntStack_4_3 클래스파일
	
}
