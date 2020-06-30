package ver01;

public class PBMain {

	public static void main(String[] args) {
		PhoneInfor info = 
				new PhoneInfor("손흥민", "000-9999-8888", "2000.11.11");
		// info.name="박지성";>>데이터가 바뀌는 문제점
		// PhoneInfor 데이터를 private로 바꿔줌

		info.showData();
		System.out.println("-----------");
		info = new PhoneInfor("박지성", "0000-7777-6666");
		info.showData();

	}

}
