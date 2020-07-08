package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Emp;

public class EmpDao {
	//외부에서 객체 생성 하는것을 막는다--> 싱글톤
	private EmpDao(){
	}
	
	//사용할 인스턴스 하나를 생성함
	private static EmpDao dao = new EmpDao();

	//외부에서 사용할 수 있는 get메서드를 만듦
	//EmpDao 인스턴스의 참조값을 반환하는 메서드
	public static EmpDao getInstance() {
		return dao;
	}
	
	
	//Connection을 매개변수로 받는이유는 트랜젝션 처리 때문이다.
	public List<Emp> getEmpList(Connection conn) throws SQLException{
		Statement stmt = null;
		//PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//Emp 객체를 담을 리스트 생성
		List <Emp> empList = new ArrayList<>();
		stmt = conn.createStatement();
		
		String sql = "select * from emp order by ename desc"; 
		//4. sql의 결과를 ResultSet에 담기
		rs = stmt.executeQuery(sql);
		
		//결과를 리스트에 add
		while(rs.next()){
			empList.add(
					new Emp(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getInt("sal"),
						rs.getString("job"),
						rs.getInt("deptno")
					)
			);
		}
		return empList;
	}
}
