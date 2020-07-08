package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.EmpDao;
import jdbc.ConnectionProvider;
import model.Emp;

public class EmpListService {
	
	
	private EmpListService() {
	}
	
	private static EmpListService els = new EmpListService();

	public static EmpListService getInstance() {
		return els;
	}
	
	EmpDao dao;
	
	//예외처리 , 트랜젝션 처리 여기서 해주긔
	public List<Emp> getEmpList() {
		// 사용할 Dao 인스턴스
		dao = EmpDao.getInstance();

		// Connection
		Connection conn = null;
		List<Emp> list = null;
		try {
			conn = ConnectionProvider.getConnection();
			list = dao.getEmpList(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
