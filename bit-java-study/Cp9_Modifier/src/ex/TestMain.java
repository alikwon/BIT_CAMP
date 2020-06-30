package ex;

public class TestMain {

	public static void main(String[] args) {
		Member member = new Member();
		
		System.out.println(member.getName());
		
		Singleton single = Singleton.getInstance();
		single.print();
	}

}
