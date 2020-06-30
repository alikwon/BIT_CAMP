package cp6_0416;

public class Animal {

	String name;

	public void setName(String name) {
		this.name = name; //this는 Animal 클래스에 의해 생성된 객체
	}

	public static void main(String[] args) {
		Animal cat = new Animal();
		cat.setName("hi");
		
		Animal dog = new Animal();
		dog.setName("hello");
		
		System.out.println(cat.name);
		System.out.println(dog.name);
	}
}
