package studygroup;

public class Test {
	public static void main(String[] args) {
//		int a = 10;
		Integer a = new Integer(10);
		System.out.println("Before: " + a);
		changeInteger(a);
		System.out.println("After: " + a);
	}

	public static void changeInteger(Integer param) {
		param += 10;
	}
}
