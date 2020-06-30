package cp6_0417;

public class Product {
	static int count = 0; // 생성된 인스턴스의 수를 저장하기 위한 변수
	int serialNo; // 인스턴스 고유의 번호
	{
		++count;
		serialNo = count;
	}

	public Product() {
	}
}
