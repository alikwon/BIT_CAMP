package card;

public class CardMain {

	public static void main(String[] args) {

//		// 인스턴스 생성
//		Card c1 = new Card();
//		c1.kind = "Heart";
//		c1.number = 7;
//		
		Card c1 = new Card("Heart",7);//매개변수 값(개수 ,타입)이 다름 

		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;

		System.out.println("첫째카드는 " + c1.kind + "이고, 숫자는 " + c1.number + "카드의 높이는 " + c1.height + ", 폭은 " + c1.width);
		System.out.println("둘째카드는 " + c2.kind + "이고, 숫자는 " + c2.number + "카드의 높이는 " + c2.height + ", 폭은 " + c2.width);
		
		System.out.println("카드의 사이즈를 변경합니다.");
		
		Card.height=125;
		Card.width= 50;//static 적용후
		
		System.out.println("첫째카드는 " + c1.kind + c1.number + "카드의 높이는 " + c1.height + ", 폭은 " + c1.width);
		System.out.println("둘째카드는 " + c2.kind + c2.number + "카드의 높이는 " + c2.height + ", 폭은 " + c2.width);
		
	}

}
