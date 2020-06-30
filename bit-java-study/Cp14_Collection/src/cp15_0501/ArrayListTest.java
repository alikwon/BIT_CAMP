package cp15_0501;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTest {
	public static void main(String[] args) {

		// List<E> ==> ArrayList<E>
		// List<E> : 저장 순서를 가진다 . 데이터의 중복저장가능
		// 순서 ==> 일괄처리 : 반복적인 동일한 작업을 빠르게 처리

		// ArrayList 인스턴스 생성 : Integer 타입의 객체'만' 저장
//	ArrayList<Integer> list = new ArrayList<Integer>();

		// 인스턴스 생성시에 자료형 생략 가능
//		ArrayList<Integer> list = new ArrayList<>();

		// LinkedList
		LinkedList<Integer> list = new LinkedList<Integer>();

//	List<Integer> list = new ArrayList<>();

		// 정의된 메서드
		// add(E) : 인스턴스 저장
		// remove(index) : 해당 index 요소를 삭제
		// size() : List요소 개수 반환
		// get(index) : 해당 index 위치의 요소를 반환

		/* 데이터의 저장 */
		list.add(30); // Auto Boxing
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
		System.out.println(list.size());
		/* 데이터의 참조 */
		System.out.println("1차 참조");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		/* 데이터의 삭제 */
		list.remove(1);
		System.out.println("2차 참조");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));


	}

}
