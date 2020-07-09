package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;
import guestbook.model.MessageListView;

public class GetMessageListService {

	private GetMessageListService() {
	}

	private static GetMessageListService gmls = new GetMessageListService();

	public static GetMessageListService getInstance() {
		return gmls;
	}

	private MessageDao dao;

	// 한페이지에 표현할 메세지 개수 --> 상수로 고정
	private final int MESSAGE_COUNT_PER_PAGE = 3;

	// 매개변수 pageNumber = 사용자가 요청한 페이지
	public MessageListView getMessageList(int pageNumber) {
		// 페이지 번호로 --> 시작행, 마지막행 구함
		// dao --> List
		Connection conn = null;
		MessageListView messageListView=null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();

			// 페이지의 전체 메세지 구하기
			List<Message> msgList = null;

			// 전체 메세지의 개수
			int msgTotalCnt = dao.selectTotalCount(conn);
			int startRaw = 0;
			int endRaw = 0;

			if (msgTotalCnt > 0) {
				// 시작행과 마지막행을 구해주자.
				// statrRaw = (사용자요청페이지 -1) * 한페이지의 메세지개수 + 1
				startRaw = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
				endRaw = startRaw + MESSAGE_COUNT_PER_PAGE - 1;
				
				msgList = dao.selectMessageList(conn, startRaw, endRaw);
			} else {
				pageNumber = 0;

				// 비어있는 객체로 만들어줌 --> new 한것과 비슷
				msgList = Collections.emptyList();
			}
			messageListView = 
					new MessageListView(
									msgList, 
									msgTotalCnt, 
									pageNumber, 
									MESSAGE_COUNT_PER_PAGE, 
									startRaw, 
									endRaw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		return messageListView;
	}
}
