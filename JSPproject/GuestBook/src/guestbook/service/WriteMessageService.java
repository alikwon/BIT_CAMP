package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class WriteMessageService {
	
	
	private WriteMessageService() {
	}
	
	private static WriteMessageService wms = new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		return wms;
	}
	
	MessageDao dao = null;
	
	
	//
	public int writeMessage(Message message) {
		int result=0;
		dao = MessageDao.getInstance();
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.insertMessage(conn, message);
		} catch (SQLException e) {
			//DB에서 나오는 예외
			e.printStackTrace();
		} catch (Exception e) {
			//이외의것
			e.printStackTrace();
		} finally {
			if(conn!= null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
