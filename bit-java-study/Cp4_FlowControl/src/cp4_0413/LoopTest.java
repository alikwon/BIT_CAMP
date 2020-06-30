package cp4_0413;

public class LoopTest {

	public static void main(String[] args) {

//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5); // 수정할 시 힘듦

		// for
		for (int i = 1; i < 6; i++) { //i는 지역변수 = for안에서만
			System.out.println(i);
		}

		// while
		int i = 1; 	// while의 경우 밖에서 초기화 한번해줘야함

		while (i < 6) {
			System.out.println(i);
			i++; 	// 중요 !★★★★★ = 탈출의 조건을 잘 만들어줘야함!!
		}

		// do-while
		i = 1;		//초기화

		do {
			System.out.println(i);
			i++;	//탈출의 조건
		} while (i < 6);

	}

}
