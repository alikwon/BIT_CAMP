package ex;

public class Member {
	
	private String name;	//public 제어자 안붙이면 Main에서 not visible
	private String id;
	
	//getter/ setter 매서드
	public String getName() { //바깥에서 name변수를 사용못하지만 
		return name;		  //메서드를 통해 값을 얻을수 잇음
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
}
