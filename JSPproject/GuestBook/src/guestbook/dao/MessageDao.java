package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;

public class MessageDao {
	private MessageDao() {
	}
	
	private static MessageDao dao = new MessageDao();
	
	public static MessageDao getInstance() {
		return dao;
	}

	public int insertMessage(Connection conn, Message message) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		//service에서 예외처리
		//finally 쓰기위해 try문 써줌
		try {
			String sql = "insert into guestbook_message values (message_id_seq.nextVal, ?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getUname());
			pstmt.setString(2, message.getPw());
			pstmt.setString(3, message.getMsg());
			
			resultCnt = pstmt.executeUpdate();
		}finally {
			if (pstmt != null) {
				pstmt.close();				
			}
		}
		return resultCnt;
	}
	
	public List<Message> selectMessageList(Connection conn, int startRaw,int endRaw) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Message> list = new ArrayList<>();
		Message msg;
		try {
			String sql = "select message_id,guest_name,password,message " + 
						 "from( " + 
						 "	select rownum rnum,message_id,guest_name,password,message " + 
						 "	from ( " + 
						 "		select * " + 
						 "		from guestbook_message m " + 
						 "		order by m.MESSAGE_ID desc " + 
						 "	) " + 
						 "	where rownum <= ?" + 
						 ") " + 
						 "where rnum >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRaw);
			pstmt.setInt(2, startRaw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				msg = new Message(
							rs.getInt("message_id"), 
							rs.getString("guest_name"), 
							rs.getString("password"), 
							rs.getString("message"));
				list.add(msg);
			}
		}finally {
			if (rs != null) {
				rs.close();				
			}
			if (pstmt != null) {
				pstmt.close();				
			}
		}
		return list;
	}

	//전체 메세지의 개수를 구하는 함수
	public int selectTotalCount(Connection conn) throws SQLException {
		int resultCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
			stmt = conn.createStatement();
			String sql ="select count(*) from guestbook_message";
			
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}	
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		return resultCnt;
	}

	public Message selectMessage(Connection conn, int mid) throws SQLException {
		Message msg =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from guestbook_message where message_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				msg = new Message(
						rs.getInt("message_id"), 
						rs.getString("guest_name"), 
						rs.getString("password"), 
						rs.getString("message"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}

		}
		return msg;
	}

	public int deleteMessage(Connection conn, int mid) throws SQLException {
		int resultCnt=0;
		
		PreparedStatement pstmt =null;
		String sql = "delete from guestbook_message where message_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			resultCnt = pstmt.executeUpdate();
			
		}finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}
}
