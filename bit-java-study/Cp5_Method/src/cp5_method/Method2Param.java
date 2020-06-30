package cp5_method;

public class Method2Param {

	public static void main(String[] args) {
		double myHeight = 175.9;
		hiEveryone(12, 12.5);//age가 int형이기 때문에 정수만
		hiEveryone(12, 120);
		hiEveryone(7, 120);
		hiEveryone(13, myHeight);
		byEveryone();
	}

	static void hiEveryone(int age, double height) { 
		//double을 float로 바꿀경우 키에 f를 붙여야함
		if (age <10)	//10살 미만일때 return(메서드 종료)
			return;
		System.out.println("제 나이는 " + age + "세 입니다.");
		System.out.println("저의 키는 " + height + "cm 입니다.");
	}

	static void byEveryone() {
		System.out.println("다음에 뵙겠습니다.");
	}
}