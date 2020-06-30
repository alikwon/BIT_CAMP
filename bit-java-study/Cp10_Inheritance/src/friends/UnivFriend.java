package friends;

public class UnivFriend extends Friend{
	private String major;	//친구 전공
	private int grade;	//친구 학년
	
	UnivFriend(String name, String phoneNum, String address
				, String eMail, String major,int grade) 
	{
		super(name, phoneNum, address, eMail);
		this.major=major;
		this.grade=grade;
	}

	//오버라이딩을 통해 타입통일(?)
	@Override
	public void showData() {	
		showBasicInfo();//상위클래스 (Friends) 매서드
		System.out.println("전공 : "+this.major);
		System.out.println("학년 : "+this.grade);
	}
	
	
	
	
		
	
}
