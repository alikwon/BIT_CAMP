package jdbc;

import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		String jdbcDrivers = config.getInitParameter("jdbcdriver");
		
		//오라클과 MySQL 드라이버 둘다 로드
		StringTokenizer st = new StringTokenizer(jdbcDrivers,",");
				
		String msg = config.getInitParameter("msg");
		System.out.println(msg);
		try {
			while(st.hasMoreTokens()) {
				String driver = st.nextToken();
				Class.forName(driver);
				System.out.println(driver+"드라이버 로드~~성공!!! loader");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드~~실패!!!");
		}
	}
	

}
