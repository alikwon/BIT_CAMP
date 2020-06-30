package cp10_poly_0424;



public class Main {

	public static void main(String[] args) {
	// 상속관계에서 다형성
	// 상위클래스 타입의 참조변수 = 하위클래스의 인스턴스

		Product p = new Product(100);
		
		// 각자 다른타입으로 해도되지만 종류가 많아지면 힘듦
		Tv tv = new Tv(10);
		Computer com = new Computer(20);
		Audio aud = new Audio(30);
		//일일히 더해야함
		int sum = tv.price + com.price + aud.price;

//		Tv tv1 = (Tv)p;
		
		
		// 같은 타입으로 묶어주면 배열로 묶을 수 잇음
		Product p1 = new Tv(10);
		Product	p1_2 = (Product)tv; //Tv타입을 상위클래스 타입으로 형변환
		Product p2 = new Computer(20);
		Product p3 = new Audio(30);
	
		((Tv)p1).display();
	//상위 클래스 타입의 배열을 생성
		Product [] products = new Product[4];
		products[0] = new Tv(150);
		products[1] = new Computer(50);
		products[2] = new Audio(100);
		products[3] = new Product(200);

		
		// products[0].display();	//오류발생
		// 참조변수의 타입에 맞는 맴버만 사용가능
		// 상위 타입변수 ==> 하위타입변수
		((Tv)products[0]).display(); 
		//(형변환타입)상위타입 배열요소.하위타입매서드
//		
//		
//		//((Computer)products[0]).programming();	
//		//products[0] 은 Tv인스턴스를 참조하므로 오류발생
//		
//		// 연산자 instanceof = 참조변수가 참조하는 인스턴스를 
//		// 특정클래스 타입으로 형변환 가능한지 여부를 확인하는것
//		for(int i = 0; i<products.length;i++) {
//			if(products[i] instanceof Computer)
//				((Computer)products[i]).programming();
//		}
//		
//		
//	// 생성된 배열요소를 더해서 총합을 구함
//		int sumOfPrice = 0;
//		int sumOfPoint = 0;
//		for(int i=0;i<products.length;i++) {
//			System.out.println(products[i]);
//			sumOfPrice += products[i].price;
//			sumOfPoint += products[i].bonusPoint;
//		}
//		System.out.println("전체 제품가격: "+sumOfPrice);
//		System.out.println("전체 포인트: "+sumOfPoint);
//		
//	// 구매 시뮬
//		// 구매자 생성
//		Buyer buyer= new Buyer();
//		
//		// 제품 생성
//		Tv product1 = new Tv(200);
//		Computer product2 = new Computer(300);
//		Audio product3 = new Audio(100);
//		
//		
//		buyer.buy(product1);// Tv 구매 
//		buyer.buy(product2);// 컴터 구매
//		buyer.buy(product3);// 오디오 구매
//		buyer.buy(product2);
//		
//		buyer.summary();
//		
//		

	}
}
