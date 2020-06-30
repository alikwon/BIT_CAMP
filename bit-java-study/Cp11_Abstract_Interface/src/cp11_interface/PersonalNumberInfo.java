package cp11_interface;

public class PersonalNumberInfo {
	//데이터 저장 목적의 클래스
	private String name;
	private String number;
	
	PersonalNumberInfo(String name, String number){
		this.name=name;
		this.number=number;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}
		
}
