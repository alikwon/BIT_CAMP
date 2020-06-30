package cp15_0501;

import java.util.Iterator;
import java.util.TreeSet;

// 정렬하려면 Comparable 구현
public class Person implements Comparable<Person> {

	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void showData() {
		System.out.println("이름 : " + this.name + ", 나이 : " + this.age);
	}

	// 구현할 메서드
	@Override
	public int compareTo(Person o) {
		int result = 0;
//		if (this.age > o.age) {
//			result = 1;
//		} else if (this.age < o.age) {
//			result = -1;
//		} else {
//			result = 0;
//		}
		result = this.age - o.age; //라고 간단히 표현가능
		return result;
	}

	public static void main(String[] args) {

		TreeSet<Person> treeSet = new TreeSet<>();

		treeSet.add(new Person("son", 27));
		treeSet.add(new Person("king", 30));
		treeSet.add(new Person("queen", 20));
		treeSet.add(new Person("son", 27));

		Iterator<Person> itr = treeSet.iterator();

		while (itr.hasNext()) {
			itr.next().showData();
		}
	}

}
