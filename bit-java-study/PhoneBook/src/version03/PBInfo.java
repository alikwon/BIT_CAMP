package version03;

public class PBInfo {
	private String name;
	private String num;
	private String birth;
	int number;	// 생성 할때 마다 번호 매겨주기
	
	public PBInfo(String name, String num, String birth) {
		
		this.name=name;
		this.num=num;
		this.birth=birth;
		this.number = PBManager.count+1;
	}
	
	public PBInfo(String name, String num) {
		this(name,num,"(입력없음)");
		this.number = PBManager.count+1;
	}
	
	public PBInfo() {}
	
	void showData() {
		System.out.println("["+number+"] "+"이름 : "+ name +", 번호 : "+ num+", 생일: "+birth);
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	
	

	
}