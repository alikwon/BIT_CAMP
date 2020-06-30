package card;

public class Card {
//	int width=100;	// 폭 
//	int height=250;	//높이
//	
//	String kind;	//문양
//	int number;		//숫자
	
	static int width=100;	// 폭 
	static int height=250;	//높이
	
	String kind;	//문양
	String number2;
	int number;		//숫자
	
	Card(){
	}
	
	Card(String type, int num){
		kind = type;
		number=num;	
	}
	
	
}
