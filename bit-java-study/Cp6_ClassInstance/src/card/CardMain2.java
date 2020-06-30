package card;

public class CardMain2 {

	public static void main(String[] args) {

		Card c = new Card();

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 14; j++) {

				String a = "";
				if (i == 1) {
					a = "Spade";
				}
				if (i == 2) {
					a = "Diamond";
				}
				if (i == 3) {
					a = "Heart";
				}
				if (i == 4) {
					a = "Cluber";
				}
				c.kind = a;
				c.number=j;
				if (j == 11) {
					c.number2 = "J";
					System.out.println("" + c.kind + c.number2);
				} else if(j==12){
					c.number2="Q";
					System.out.println("" + c.kind + c.number2);
				} else if(j==13){
					c.number2="K";
					System.out.println("" + c.kind + c.number2);
				}else {
					System.out.println("" + c.kind + c.number);
				}
			}
		}

	}
}



