package cp7_0420;

import cp7_0420.Friend;

public class Friend {String myName;

Friend(String name) {
	myName = name;
}

//Object 클래스의 toString() 매서드를 재 구성한다 >> 오버라이딩
//메서드의 선언부가 원본 메서드의 선언부와 동일해야한다.
//기존에 있던 메서드를 고침
//public String toString() {
//	return "제 이름은 " + this.myName + "입니다";
//}

public static void main(String[] args) {

	Friend f1 = new Friend("손흥민");
	Friend f2 = new Friend("박지성");

	System.out.println(f1.toString()); // 해시코드 값이 출력
	System.out.println(f1); // 참조변수만 전달해도 해시코드값이 출력

	System.out.println(f2.toString());
	System.out.println(f2);
}

//// Alt+Shift+S >> Generate toString()
//@Override
//public String toString() {
//	return "Friend [myName=" + myName + "]";
//}

}
