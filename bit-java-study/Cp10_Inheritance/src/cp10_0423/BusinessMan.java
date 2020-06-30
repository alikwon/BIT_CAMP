package cp10_0423;

public class BusinessMan extends Man {
	String company;
	String position;
	//상위클래스에 생성자가 있다면 하위클래스의 생성자에서 
	//값을 받아 상위클래스에 생성자를 호출해서 초기화해준다
	public BusinessMan(String name,String company,String position ) {
		super(name); //바로 위의★  상위클래스(Man) 데이터 호출
		this.company=company;
		this.position=position;
	}
	
	void tellYourInfo() {
		//super.tellYourName();
		tellYourName();
		System.out.println("직장이름 : "+company);
		System.out.println("직급 : "+position);
	}
}
