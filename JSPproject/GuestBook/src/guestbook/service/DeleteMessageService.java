package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class DeleteMessageService {
	
	private DeleteMessageService() {}
	private static DeleteMessageService dms = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return dms;
	}
	
	MessageDao dao;
	
	public int deleteMessage(int mid, String pw) {
		int resultCnt =0;
		Connection conn = null;
		Message msg = null;
		//1. mid의 메세지 존재 확인
		//2. 메세지가 존재하면 객체의 pw과 사용자가 입력한pw 비교
		//3. 비교의 결과가 같으면 mid의 메세지를 삭제
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			msg = dao.selectMessage(conn,mid);
			
			if (msg == null) {
				resultCnt = -1;
				throw new Exception("삭제할 게시물이 없닷!");
			}
			
			if(!msg.getPw().equals(pw)) {
				resultCnt = -2;
				throw new Exception("비번틀림요 ㅇㅇ");
			}
			//삭제
			resultCnt=dao.deleteMessage(conn, mid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
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
		
		return resultCnt;
	}
}
