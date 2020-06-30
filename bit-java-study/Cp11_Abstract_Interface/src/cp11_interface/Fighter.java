package cp11_interface;

public class Fighter implements Fightable {

	@Override
	public void move() {
		System.out.println("움직인당");
		
	}

	@Override
	public void attact() {
		System.out.println("공격한당");
		
	}



}
