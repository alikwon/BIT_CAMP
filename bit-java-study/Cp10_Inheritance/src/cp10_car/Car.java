package cp10_car;

public class Car {
	
	
	String color;
	int door;

	void drive() {
		System.out.println("운 전~~~");
	}

	void stop() {
		System.out.println("정 지~~~");
	}
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		Ambulance am = null;
		fe1.water();
		car = fe1; // 하위클래스 (파이어엔진)에서 상위클래스 (카)로 가니까 형변환 안해도됨
		// car.water(); 사용할수 없음

		fe2 = (FireEngine) car; // 하위클래스로 대입될땐 명시적 형변환
		
		if (car instanceof Ambulance) {
			am = (Ambulance)car;
			am.siren();
		}
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("물!!!!!!!!!");
	}
}

class Ambulance extends Car {
	void siren() {
		System.out.println("웨~~~~~~~~엥!!!!");

	}

	
}
