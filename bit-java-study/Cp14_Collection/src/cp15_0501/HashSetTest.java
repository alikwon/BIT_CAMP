
package cp15_0501;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	
	public static void main(String[] args) {
//		HashSet<String> hSet = new HashSet<String>();
//		hSet.add("First");
//		hSet.add("Second");
//		hSet.add("Third");
//		hSet.add("First");

		HashSet<SimpleNumber> hSet = new HashSet<SimpleNumber>();
		hSet.add(new SimpleNumber(10));
		hSet.add(new SimpleNumber(20));
		hSet.add(new SimpleNumber(30));
		
		System.out.println("저장된 데이터수 : "+hSet.size());
		
		Iterator<SimpleNumber> itr = hSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		

	}

}

	//HashSet 의 동등 비교과정
	//1. hash 코드를 비교, 같은 hash 코드를 가진 객체를 기반으로 동등 비교
	//2. equals 메서드로 비교
class SimpleNumber{
	int num;
	public SimpleNumber(int n) {
		num = n;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
}
