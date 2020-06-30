package user;

import java.util.ArrayList;

import Ticket.Ticket;

public class Info {
	
	private int myMoney;
	private int point;
	private String birth;
	private ArrayList<Ticket> tickets;
	public int getMyMoney() {
		return myMoney;
	}
	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getBirth() {
		return birth;
	}
//	public void setBirth(int birth) {
//		this.birth = birth;
//	}
	public void showAllMyTicket() {
		
	}
	

	
}
