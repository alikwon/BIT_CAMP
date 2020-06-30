package cp15_0501;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		//HashMap<Integer, String> map = new HashMap<Integer, String>();
		//HashMap<Integer, String> map = new HashMap<>();
		
		//다형성
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//입력방법
		map.put(1, "일번");
		map.put(2, "이번");
		map.put(3, "삼번");
				
		//참조방법
		System.out.println("일번 학생 이름 : "+ map.get(1));
		System.out.println("이번 학생 이름 : "+ map.get(2));
		System.out.println("삼번 학생 이름 : "+ map.get(3));
		
		//삭제 >>key 기반으로
		map.remove(2); //null 값 반환
		System.out.println("이번 학생 이름 : "+ map.get(2));
		
		//key값 중복 허용 안됨
		map.put(1, "1번");
		System.out.println("일번 학생 이름 : "+ map.get(1));
		
		
		
		
	}
}
