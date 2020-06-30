package cp11_interface;

public class P_AbstractInterfaceMain {

	public static void main(String[] args) {
		
		// 상위 클래스 = PersonalNumberStorage (추상클래스)
//		PersonalNumberStorage storage 
//					= new PersonalNumberStorageImpl(100);
		
		
		PersonalNumInter storage = new PersonalNumberStorageImpl(100);
		//추상매서드긴 하지만 불러올순 있음
		storage.addPersonalInfo("202020", "흥민쏜");
		storage.addPersonalInfo("101010", "지성팍");
		
		System.out.println(storage.searchName("202020"));
		System.out.println(storage.searchName("101010"));
		
	}
}
