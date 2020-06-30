package cp6_0417;

public class PersonOverloading {

	public static void main(String[] args) {
		Person man = new Person(950123, 880102, 1995, 12, 3);
		Person woman = new Person(990117, 1999, 11, 7);
		man.showInfo();
		woman.showInfo();

	}

}
