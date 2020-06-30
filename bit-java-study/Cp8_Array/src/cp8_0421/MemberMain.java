package cp8_0421;

public class MemberMain {

	public static void main(String[] args) {
		//회원정보 5개 저장 배열생성;
		//Member 타입의 인스턴스 참조값을 저장하는 메모리 공간
		//Member m1,m2,m3,m4,m5 >> 변수 5개를 생성한 것과 같다
		Member[] members=new Member[5];
		
		members[0]=new Member("cool","쿨","cool@gmail.com");//Member 타입의 인스턴스 주소
		members[1]=new Member("hot","뜨거","hot@gmail.com");
		members[2]=new Member("cold","추워","cold@gmail.com");
		members[3]=new Member("son","손흥민","son@gmail.com");
		
//		members[0].showInfo();
//		members[1].showInfo();
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo();
		
		for(int i =0; i<members.length;i++) {
			if (members[i]==null)
				break;
			System.out.println(members[i]);
		}
		System.out.println("==================");
		
		for(int i =0; i<members.length;i++) {
			if (members[i]==null)
				break;
			members[i].showInfo();
			System.out.println("-------------");
		}
		
//		Member member = new Member("cool","쿨","cool@gmail.com");
//		
//		member.showInfo();
//		
//		System.out.println("-------------");
//		System.out.println(member);//member.toString() 호출
	}

}
