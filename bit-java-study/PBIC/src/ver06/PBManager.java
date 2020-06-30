package ver06;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PBManager {

	Scanner sc;
	InfoDao iDao = new InfoDao();

	public PBManager() {
		sc = new Scanner(System.in);
	}

	void insertInfo() {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			PhoneUnivInfo UInfo = null;
			PhoneCafeInfo FInfo = null;
			PhoneCompanyInfo CInfo = null;
			String name = null;
			String pNumber = null;
			String addr = null;
			String email = null;
			String major = null;
			int year = 0;
			String company = null;
			String dept = null;
			String job = null;
			String cafeName = null;
			String nickName = null;
			int rsCnt = 0;
			int select = 0;
			System.out.println("<<카테고리 선택>>");
			System.out.println("1.대학 친구");
			System.out.println("2.회사 친구");
			System.out.println("3.동호회 친구");
			select = Integer.parseInt(sc.nextLine().trim());

			System.out.println("기본정보를 먼저 입력하세요");
			System.out.println("이름입력>>");
			name = sc.nextLine().trim();
			System.out.println("전화번호입력>>");
			pNumber = sc.nextLine().trim();
			System.out.println("주소입력>>");
			addr = sc.nextLine().trim();
			System.out.println("이메일 입력 >>");
			email = sc.nextLine().trim();
			switch (select) {
			case 1:
				System.out.println("대학 정보를 입력합니다");
				System.out.println("전공입력>>");
				major = sc.nextLine().trim();
				System.out.println("학년 입력>>");
				year = Integer.parseInt(sc.nextLine().trim());
				UInfo = new PhoneUnivInfo(name, pNumber, addr, email, major, year);
				rsCnt = iDao.univInsert(UInfo, conn);

				if (rsCnt > 0) {
					System.out.println(rsCnt + "개 정보가 입력됐습니다");
					conn.commit();
					return;
				} else {
					System.out.println("입력실패. 확인 후 다시시도하세요");
					conn.rollback();
					return;
				}
			case 2:
				System.out.println("회사 정보를 입력합니다");
				System.out.println("회사이름 입력>>");
				company = sc.nextLine().trim();
				System.out.println("부서입력>>");
				dept = sc.nextLine().trim();
				System.out.println("직급입력>>");
				job = sc.nextLine().trim();
				CInfo = new PhoneCompanyInfo(name, pNumber, addr, email, company, dept, job);
				rsCnt = iDao.comInsert(CInfo, conn);

				if (rsCnt > 0) {
					System.out.println(rsCnt + "개 정보가 입력됐습니다");
					conn.commit();
					return;
				} else {
					System.out.println("입력실패. 확인 후 다시시도하세요");
					conn.rollback();
					return;
				}
			case 3:
				System.out.println("동호회 정보를 입력합니다");
				System.out.println("동호회 이름 입력>>");
				cafeName = sc.nextLine().trim();
				System.out.println("닉네임 입력>>");
				nickName = sc.nextLine().trim();
				FInfo = new PhoneCafeInfo(name, pNumber, addr, email, cafeName, nickName);

				rsCnt = iDao.cafeInsert(FInfo, conn);

				if (rsCnt > 0) {
					System.out.println(rsCnt + "개 정보가 입력됐습니다");
					conn.commit();
					return;
				} else {
					System.out.println("입력실패. 확인 후 다시시도하세요");
					conn.rollback();
					return;
				}
			}

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("conn.close()");
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}

	// 친구 찾기
	// 이름으로 검색
	List<PhoneInfo> searchInfo() {
		Connection conn = null;
		List<PhoneInfo> list = new ArrayList<>();
		try {
			conn = ConnectionProvider.getConnection();
			System.out.println("검색할 이름 입력>>");
			String name = sc.nextLine().trim();

			list = iDao.searchInfo(name, conn);
			if (list == null || list.isEmpty()) {
				System.out.println("찾는 이름이 없습니다");
				return list;
			}
//			if (list.get(0) instanceof PhoneUnivInfo) {
//				System.out.printf("%10s", "이름" + "\t┃");
//				System.out.printf("%15s", "전번" + "\t┃");
//				System.out.printf("%15s", "주소" + "\t┃");
//				System.out.printf("%15s", "이메일" + "\t┃");
//				System.out.printf("%10s", "전공" + "\t┃");
//				System.out.printf("%9s", "학년" + "\n");
//				System.out.println(
//						"━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━");
//
//			}
//			if (list.get(0) instanceof PhoneCompanyInfo) {
//				System.out.printf("%10s", "이름" + "\t┃");
//				System.out.printf("%15s", "전번" + "\t┃");
//				System.out.printf("%15s", "주소" + "\t┃");
//				System.out.printf("%15s", "이메일" + "\t┃");
//				System.out.printf("%15s", "회사" + "\t┃");
//				System.out.printf("%10s", "부서" + "\t┃");
//				System.out.printf("%10s", "직급" + "\n");
//				System.out.println(
//						"━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━");
//			}
//			if (list.get(0) instanceof PhoneCafeInfo) {
//				System.out.printf("%10s", "이름" + "\t┃");
//				System.out.printf("%15s", "전번" + "\t┃");
//				System.out.printf("%15s", "주소" + "\t┃");
//				System.out.printf("%15s", "이메일" + "\t┃");
//				System.out.printf("%10s", "동호회이름" + "\t┃");
//				System.out.printf("%10s", "닉네임" + "\n");
//				System.out.println(
//						"━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━");
//			}

			for (int i = 0; i < list.size(); i++) {

				if (list.get(i) instanceof PhoneUnivInfo) {
					System.out.printf("%5s", list.get(i).getName() + "\t│");
					System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
					System.out.printf("%15s", list.get(i).getAddr() + "\t│");
					System.out.printf("%15s", list.get(i).getEmail() + "\t│");
					System.out.printf("%10s", list.get(i).getMajor() + "\t│");
					System.out.printf("%10s", list.get(i).getYear() + "\n");
					System.out.println(
							"────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼");
				}
				if (list.get(i) instanceof PhoneCompanyInfo) {
					System.out.printf("%5s", list.get(i).getName() + "\t│");
					System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
					System.out.printf("%15s", list.get(i).getAddr() + "\t│");
					System.out.printf("%15s", list.get(i).getEmail() + "\t│");
					System.out.printf("%15s", list.get(i).getCompany() + "\t│");
					System.out.printf("%10s", list.get(i).getDept() + "\t│");
					System.out.printf("%10s", list.get(i).getJob() + "\n");
					System.out.println(
							"────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼─────────────┼");
				}
				if (list.get(i) instanceof PhoneCafeInfo) {

					System.out.printf("%5s", list.get(i).getName() + "\t│");
					System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
					System.out.printf("%15s", list.get(i).getAddr() + "\t│");
					System.out.printf("%15s", list.get(i).getEmail() + "\t│");
					System.out.printf("%10s", list.get(i).getCafeName() + "\t│");
					System.out.printf("%10s", list.get(i).getNickName() + "\n");
					System.out.println(
							"────────┼───────────────┼───────────────┼───────────────┼───────────────┼─────────────┼");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	void deleteInfo() {
		Connection conn = null;
		String name = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			System.out.println("삭제할 이름 입력>>");
			name = sc.nextLine().trim();
			List<PhoneInfo> list = iDao.searchInfo(name, conn);
			if (list == null || list.isEmpty()) {
				System.out.println("저장되지 않은 이름입니다");
				return;
			}
			if (list.size() > 0) {
				System.out.println(list.size() + "개의 정보가 있습니다");

				for (int i = 0; i < list.size(); i++) {
					System.out.printf("%5s", i + 1 + "│");
					System.out.printf("%5s", list.get(i).getName() + "\t│");
					System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
					System.out.printf("%15s", list.get(i).getAddr() + "\t│");
					System.out.printf("%15s", list.get(i).getEmail() + "\n");
					System.out.println("────┼───────────┼───────────────┼───────────────┼───────────────");
				}
				System.out.println("정말 삭제하시려면 저장된 정보의 번호를 입력하세요");
				int select = Integer.parseInt(sc.nextLine().trim());

				result = iDao.deleteInfo(list.get(select - 1).getIdx(), conn);
				System.out.println(result + "개 정보가 삭제 됐습니다.");
				conn.commit();
				return;
			} else {
				System.out.println("삭제실패.확인후 다시해주세요");
				conn.rollback();
				return;
			}

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("conn.close()");
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}

	void editInfo() {
		Connection conn = null;
		String name=null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			System.out.println("수정할 친구의 이름 입력>>");
			name = sc.nextLine().trim();
			List<PhoneInfo> list = iDao.searchInfo(name, conn);
			if (list == null || list.isEmpty()) {
				System.out.println("저장되지 않은 이름입니다");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void showInfo() {
		int select = 0;
		System.out.println("어떤 정보를 보시겠어요?");
		System.out.println("1. 학교친구 정보");
		System.out.println("2. 회사친구 정보");
		System.out.println("3. 동호회친구 정보");
		select = Integer.parseInt(sc.nextLine().trim());
		switch (select) {
		case 1:
			showUnivInfo();
			break;
		case 2:
			showComInfo();
			break;
		case 3:
			showCafeInfo();
			break;
		}
	}

	void showUnivInfo() {
		List<PhoneInfo> list = null;
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			list = iDao.showUnivInfo(conn);
			if (list.size() < 1) {
				System.out.println("저장된 정보가 없습니다");
				return;
			}
			System.out.printf("%10s", "이름" + "\t┃");
			System.out.printf("%15s", "전번" + "\t┃");
			System.out.printf("%15s", "주소" + "\t┃");
			System.out.printf("%15s", "이메일" + "\t┃");
			System.out.printf("%10s", "전공" + "\t┃");
			System.out.printf("%9s", "학년" + "\n");
			System.out.println(
					"━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇" 
			+ "━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━");

			for (int i = 0; i < list.size(); i++) {
				System.out.printf("%5s", list.get(i).getName() + "\t│");
				System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
				System.out.printf("%15s", list.get(i).getAddr() + "\t│");
				System.out.printf("%15s", list.get(i).getEmail() + "\t│");
				System.out.printf("%10s", list.get(i).getMajor() + "\t│");
				System.out.printf("%10s", list.get(i).getYear() + "\n");
				System.out.println(
						"────────┼───────────────┼───────────────" 
				+ "┼───────────────┼───────────────┼────────────");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

	}

	void showComInfo() {
		List<PhoneInfo> list = null;
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			list = iDao.showComInfo(conn);
			if (list.size() < 1) {
				System.out.println("저장된 정보가 없습니다");
				return;
			}
			System.out.printf("%10s", "이름" + "\t┃");
			System.out.printf("%15s", "전번" + "\t┃");
			System.out.printf("%15s", "주소" + "\t┃");
			System.out.printf("%15s", "이메일" + "\t┃");
			System.out.printf("%15s", "회사" + "\t┃");
			System.out.printf("%10s", "부서" + "\t┃");
			System.out.printf("%10s", "직급" + "\n");
			System.out.println(
					"━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━"
					+ "━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("%5s", list.get(i).getName() + "\t│");
				System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
				System.out.printf("%15s", list.get(i).getAddr() + "\t│");
				System.out.printf("%15s", list.get(i).getEmail() + "\t│");
				System.out.printf("%15s", list.get(i).getCompany() + "\t│");
				System.out.printf("%10s", list.get(i).getDept() + "\t│");
				System.out.printf("%10s", list.get(i).getJob() + "\n");
				System.out.println("────────┼───────────────┼───────────────┼"
						+ "───────────────┼───────────────┼───────────────┼" 
						+ "─────────────┼");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}

	void showCafeInfo() {
		List<PhoneInfo> list = null;
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			list = iDao.showCafeInfo(conn);
			if (list.size() < 1) {
				System.out.println("저장된 정보가 없습니다");
				return;
			}
			System.out.printf("%10s", "이름" + "\t┃");
			System.out.printf("%15s", "전번" + "\t┃");
			System.out.printf("%15s", "주소" + "\t┃");
			System.out.printf("%15s", "이메일" + "\t┃");
			System.out.printf("%10s", "동호회이름" + "\t┃");
			System.out.printf("%10s", "닉네임" + "\n");
			System.out.println(
					"━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━"
					+ "━━━━━━━╇━━━━━━━━━━━━━━━╇━━━━━━━━━━━━━");
			for (int i = 0; i < list.size(); i++) {
				System.out.printf("%5s", list.get(i).getName() + "\t│");
				System.out.printf("%15s", list.get(i).getpNumber() + "\t│");
				System.out.printf("%15s", list.get(i).getAddr() + "\t│");
				System.out.printf("%15s", list.get(i).getEmail() + "\t│");
				System.out.printf("%10s", list.get(i).getCafeName() + "\t│");
				System.out.printf("%10s", list.get(i).getNickName() + "\n");
				System.out.println("────────┼───────────────┼───────────────┼"
						+ "───────────────┼───────────────┼─────────────┼");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
}

