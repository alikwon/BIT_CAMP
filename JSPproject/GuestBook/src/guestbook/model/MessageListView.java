package guestbook.model;

import java.util.List;

public class MessageListView {
	
	//메세지 리스트
	private List<Message> msgList;
	//전체 게시물의 개수
	private int msgTotalCount;
	//현재 페이지 번호
	private int currentPageNumber;
	//전체페이지의 개수
	private int pageTotalCount;
	//페이지당 표현 게시물의 개수
	private int msgCountPerPage;
	//게시물 시작행
	private int startRaw;
	//게시물 마지막행
	private int endRaw;
	
	public MessageListView(List<Message> msgList, 
						   int msgTotalCount, 
						   int currentPageNumber, 
						   int msgCountPerPage,
						   int startRaw, 
						   int endRaw) {
		this.msgList = msgList;
		this.msgTotalCount = msgTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.msgCountPerPage = msgCountPerPage;
		this.startRaw = startRaw;
		this.endRaw = endRaw;
		calTotalPageCount();
	}
	
	//전체페이지의 개수를 입력해주는 함수
	//사과바구니 생각하셈
	private void calTotalPageCount() {
		if(msgTotalCount==0) {
			pageTotalCount=0;
		}else {
			pageTotalCount= msgTotalCount/msgCountPerPage;
			if(msgTotalCount%msgCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	//변경되면 안되도록 getter만...
	public List<Message> getMsgList() {
		return msgList;
	}

	public int getMsgTotalCount() {
		return msgTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMsgCountPerPage() {
		return msgCountPerPage;
	}

	public int getStartRaw() {
		return startRaw;
	}

	public int getEndRaw() {
		return endRaw;
	}

	@Override
	public String toString() {
		return "MessageListView [msgList=" + msgList + ", msgTotalCount=" + msgTotalCount + ", currentPageNumber="
				+ currentPageNumber + ", pageTotalCount=" + pageTotalCount + ", msgCountPerPage=" + msgCountPerPage
				+ ", startRaw=" + startRaw + ", endRaw=" + endRaw + "]";
	}
	
	//getEmpty() 가 아니라도 empty()로 호출가능 
	public boolean isEmpty() {
		return msgTotalCount==0;
	}
}
