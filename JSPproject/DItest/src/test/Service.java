package test;

public class Service {
	/* 서비스에서 Dao클래스 인스턴스 생성 Service 클래스는 Dao 클래스에 의존한다*/
//	Dao dao = new Dao();
	
	/*Dao클래스를 지운뒤 -->인터페이스를 통해서 의존성을 낮추기 */
	Dao dao;
	
	public Service(Dao dao) {
		this.dao=dao;
	}
	public void setDao(Dao dao) {
		this.dao=dao;
	}
	
	public void print() {
		dao.print();
	}
}
