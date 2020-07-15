package member.model;

import java.util.List;


public class MemberList {

		//회원 리스트
		private List<Member> mbList;
		//전체 게시물의 개수
		private int memberTotalCount;
		//현재 페이지 번호
		private int currentPageNumber;
		//전체페이지의 개수
		private int pageTotalCount;
		//페이지당 표현 게시물의 개수
		private int memberCountPerPage;
		//게시물 시작행
		private int startRaw;
		public MemberList(List<Member> mbList, int memberTotalCount, int currentPageNumber, int pageTotalCount,
				int memberCountPerPage, int startRaw) {
			super();
			this.mbList = mbList;
			this.memberTotalCount = memberTotalCount;
			this.currentPageNumber = currentPageNumber;
			this.pageTotalCount = pageTotalCount;
			this.memberCountPerPage = memberCountPerPage;
			this.startRaw = startRaw;
			calTotalPageCount();
		}
		
		private void calTotalPageCount() {
			if(memberTotalCount==0) {
				pageTotalCount=0;
			}else {
				pageTotalCount= memberTotalCount/memberCountPerPage;
				if(memberTotalCount%memberCountPerPage > 0) {
					pageTotalCount++;
				}
			}
		}

		public List<Member> getMbList() {
			return mbList;
		}

		public int getMemberTotalCount() {
			return memberTotalCount;
		}

		public int getCurrentPageNumber() {
			return currentPageNumber;
		}

		public int getPageTotalCount() {
			return pageTotalCount;
		}

		public int getMemberCountPerPage() {
			return memberCountPerPage;
		}

		public int getStartRaw() {
			return startRaw;
		}

		@Override
		public String toString() {
			return "MemberList [msgList=" + mbList + ", memberTotalCount=" + memberTotalCount + ", currentPageNumber="
					+ currentPageNumber + ", pageTotalCount=" + pageTotalCount + ", memberCountPerPage="
					+ memberCountPerPage + ", startRaw=" + startRaw + "]";
		}
		
		public boolean isEmpty() {
			return memberTotalCount==0;
		}
		
}
