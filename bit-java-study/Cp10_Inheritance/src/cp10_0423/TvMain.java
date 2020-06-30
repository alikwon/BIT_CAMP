package cp10_0423;

public class TvMain {
	public static void main(String[] args) {

		Tv tv1 = new Tv();

		TvCaption cTv1 = new TvCaption();

		Tv tv2 = new TvCaption();
		TvCaption tv5 = (TvCaption)new Tv(); //명시적 형변환
		
		tv2.display();
		
		System.out.println(tv2.power);
		tv2.power();
		System.out.println(tv2.power);
		
		
		Tv tv3 = new TvIP()	;
		Tv tv4 = new TvSmart();
		
		tv3.display();
		tv4.display();
		
		
		
		Tv [] tvs = new Tv[4];
		
		tvs [0]= new Tv();
		tvs [1]= new TvCaption();
		tvs [2]= new TvIP();
		tvs [3]= new TvSmart(); //서로다른 타입의 인스턴스들
		
		for (int i=0; i<tvs.length;i++) {
			tvs[i].display();
		}
		
		
		
		
		

	}

}
