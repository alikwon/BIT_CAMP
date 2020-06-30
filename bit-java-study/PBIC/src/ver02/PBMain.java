package ver02;

/*	
	static 메서드는 프로그램 끝날때 까지 유지 >> 자제
	static{}(초기화블럭) : 프로그램 시작시 한번
*/
public class PBMain {

	public static void main(String[] args) {

		PBManager manager = new PBManager();
		
		//PhoneInfor에 메서드까지 구성하면
		//info 객체가 만들어질때마다 메서드까지 생성됨
		//객체 중심으로 생각하기
		PhoneInfor info=null; //반복문안에 선언되면 불필요한 변수 생성반복됨
		while(true) {
			info = manager.createInstance();
			// System.out.println(manager.createInstance()); 주소값나옴
			info.showData();
			
		}
	}

}
