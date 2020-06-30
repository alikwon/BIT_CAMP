package user;

import java.util.ArrayList;

import Ticket.Ticket;

public class NoMemberInfo extends Info{

	private String phoneNum;
	private ArrayList<Ticket>tickets;
	private int myMoney;
	private String birth="99";
	
	public NoMemberInfo(String phoneNum) {
		myMoney=20000;
		this.phoneNum=phoneNum;
		tickets = new ArrayList<Ticket>();
	}
	
	
	
	
	
	public String getBirth() {
		return birth;
	}





	public void setBirth(String birth) {
		this.birth = birth;
	}





	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}




	public ArrayList<Ticket> getTickets() {
		return tickets;
	}


	public void setTicket(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}


	public int getMyMoney() {
		return myMoney;
	}


	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}
	
	
	public void showAllMyTicket() {
		try {
			for(int i =0 ; i<tickets.size();i++) {
				tickets.get(i).showTicket();
				System.out.println("-----------------------------------");
			}
		} catch(NullPointerException e) {
			System.out.println("예매된 내역이 없습니다.");
			return;
			
		}
	}

	public void showResevInfo() {
		System.out.println("전화번호 : "+phoneNum);
		System.out.println("================================");
		this.showAllMyTicket();
	}
	
	
}
