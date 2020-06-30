package cp3_exs;

public class Temp {

	public static void main(String[] args) {
		int fahrenheit =100;
		float celcius = (int)(5/9f*(fahrenheit - 32)*100+0.5)/100f;
		//0.5를 더해서 절사해버리기(반올림)
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);


	}

}
