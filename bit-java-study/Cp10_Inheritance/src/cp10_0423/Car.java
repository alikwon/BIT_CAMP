package cp10_0423;

public class Car {
	int gasolinegauge;

	Car(int gasolinegauge) {
		this.gasolinegauge=gasolinegauge;
	}
}

class HybridCar extends Car {
	int electronicGauge;
	HybridCar(int gasolinegauge,int elelectronicGauge) {
		super(gasolinegauge);
		this.electronicGauge=elelectronicGauge;
	}

}

class HybridWaterCar extends HybridCar {
	int waterGauge;
	HybridWaterCar(int gasolinegauge,int elelectronicGauge,int waterGauge){
		super(gasolinegauge,elelectronicGauge);
		this.waterGauge=waterGauge;
	}
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolinegauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
	}
}
