package friends;

public class HighFriend extends Friend {
	private String work;//친구 직업
	
	public HighFriend(String name, String phoneNum, String address
						, String eMail, String work) 
	{
		super(name, phoneNum, address, eMail);
		this.work = work;
	}
	@Override
	public void showData() {
		showBasicInfo();	//상위클래스 매서드
		System.out.println("직업 : "+work);
	}
	
	
	
}
