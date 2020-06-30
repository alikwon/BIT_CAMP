package cp11_interface;

public abstract class PersonalNumberStorage {
	
	//요구사항 
	//1. 정보를 add 할수있는 메서드
	//2. 정보를 찾아서 이름을 반환하는 메서드
	public abstract void addPersonalInfo(String perNum, String name);
	public abstract String searchName(String perNum);
	
}
