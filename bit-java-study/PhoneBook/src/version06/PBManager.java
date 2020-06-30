
package version06;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Scanner;

public class PBManager {

	private static PBManager manager = new PBManager();

	public static PBManager getInstance() {
		return manager;
	}

	static Scanner input = new Scanner(System.in);
	private LinkedList<PBInfo> userList = new LinkedList<PBInfo>();

	PBInfo info;
	int infoNum;

	private PBManager() {

		userList = new LinkedList<PBInfo>();

		infoNum = 0;
		info = null;
	}

	boolean chooseAOrB() {

		String answer = input.nextLine().trim();
		boolean ans = true;
		if (answer.equals("1") || answer.equals("2")) {
			if (answer.equals("2"))
				ans = false;
		} else {
			System.out.println("잘못된 입력이에요. 다시 입력하세요");
			chooseAOrB();
		}
		return ans;
	}

	String inputData(String data) {
		String str = null;
		System.out.print(data + "을(를) 입력 해주세요 \n=> ");

		try {
			str = input.nextLine().trim();

			if (str == null || str.isEmpty()) {
				System.out.println("입력하지 않으셨어요");
				throw new MyException();
			}
		} catch (MyException e) {
			inputData(data);
		}
		return str;
	}

	void createInstance() {
		String name = null;
		String phoneNum = null;
		String birth = null;
		String address = null;
		String email = null;
		String major = null;
		String year = null;
		String company = null;

		int choiceNum = 0;
		while (true) {
			System.out.println(" 1. 대학정보    2. 회사정보");
			System.out.print(" ==> ");
			try {
				choiceNum = Integer.parseInt(input.nextLine().trim());
				if (!(choiceNum == 2 || choiceNum == 1)) {
					throw new MyException();
				} else
					break;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력이에요. 다시 입력하세요");
				continue;
			} catch (MyException e) {
				System.out.println("잘못된 입력이에요. 다시 입력하세요");
				continue;
			}
		}

		name = inputData("○ 이름");

		phoneNum = inputData("○ 번호");

		System.out.print("○ 생일을 입력해주세요(건너뛰려면 Enter)\n=> ");
		birth = input.nextLine().trim();
		if (birth == null || birth.trim().isEmpty()) {
			birth = "(입력없음)";
		}
		switch (choiceNum) {

		case 1:
			address = inputData("○ 주소");
			email = inputData("○ 메일");
			major = inputData("○ 전공");
			year = inputData("○ 학년");
			System.out.println();
			System.out.print("○ 입력한 정보 \n>>");
			info = new PBUnivInfo(name, phoneNum, birth, infoNum, address, email, major, year);
			info.showAllData();
			break;
		case 2:
			email = inputData("○ 메일");
			company = inputData("○ 직장");
			System.out.println();
			System.out.print("○ 입력한 정보 \n>>");
			info = new PBCompanyInfo(name, phoneNum, birth, infoNum, email, company);
			info.showAllData();

		}
		System.out.println();
		System.out.println("- 입력하신 정보가 맞나요?");
		System.out.println(" 1: Yes    2:No\n =>");
		if (chooseAOrB()) {
			saveData(info);
			return;
		} else {
			System.out.println("다시 입력해주세요");
			createInstance();
		}
	}

	// ������ �ν��Ͻ� ����
	void saveData(PBInfo pBInfo) {
		userList.add(pBInfo);
		infoNum++;
		System.out.println("★★ 정보가 저장됐어요 ★★");
	}

	// ��ü ���� ���
	void showAll() {
		if (userList.size() == 0) {
			System.out.println("( 저장된 이름이 하나도 없어요 )");
			return;
		}

		System.out.print("1: 기본정보보기    2: 상세정보보기\n =>");
		if (chooseAOrB()) {
			for (int i = 0; i < userList.size(); i++) {
//				System.out.print("[");
//				System.out.print(i + 1 + "]");
				System.out.print(userList.get(i).getInfoNumber()+")");
				userList.get(i).showBasicData();
			}
		} else {
			for (int i = 0; i < userList.size(); i++) {
				System.out.print("[");
				System.out.print(i + 1 + "]  ");
				userList.get(i).showAllData();
			}
		}
		System.out.println("----------------------");
		System.out.println("○ 현재 저장된 번호 개수: " + userList.size());
	}

	int searchData() {

		String name = inputData("이름");

		int searchCnt = 0;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).checkName(name)) {
				searchCnt += 1;
			}
		}

		if (searchCnt == 0) {
			System.out.println("입력하신 이름의 정보는 없어요");
			System.out.println();
			System.out.println("다시 검색하시겠어요?");
			System.out.print(" 1: Yes    2:No\n =>");
			if (chooseAOrB()) {
				searchData();
			} else {
				return searchCnt;
			}

		} else {

			System.out.println();
			System.out.println("  ★★ 검색결과 ★★");
			System.out.println("○ 입력하신 이름으로 " + searchCnt + "명 검색됐어요");

			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).checkName(name)) {
					System.out.print("[" + userList.get(i).getInfoNumber() + "]");
					userList.get(i).showAllData();
				}
			}

		}

		return searchCnt;
	}

	void delData() {

		String select = null;
		int index = 0;

		int searchCnt = searchData();

		if (searchCnt >= 1) {
				System.out.print("삭제하실 이름의 ");
				select = inputData("번호");
		}
		int selectNum = Integer.parseInt(select);

		System.out.println("정말로 삭제하시겠어요?");
		System.out.print(" 1: Yes    2:No\n =>");

		if (chooseAOrB()) {

			for (int i = 0; i < userList.size(); i++) {
				if (selectNum == userList.get(i).getInfoNumber()) {
					index = i;
					userList.remove(i);
					break;
				}
			}
			for (int i = index; i < userList.size(); i++) {
				userList.get(i).setInfoNumber();
			}

			System.out.println("★★ 정보가 삭제 됐어요 ★★");
			infoNum--;
		} else
			return;
	}

	void editData() {

		String select = null;
		int index = 0;

		int searchCnt = searchData();

		if (searchCnt >= 1) {
			while (true) {
				System.out.print("수정하실 이름의 ");
				select = inputData("번호");
				if (Integer.parseInt(select) > searchCnt) {
					System.out.print("잘못된 번호에요. 다시 입력하세요\n=> ");
					continue;
				} else
					break;
			}

			int selectNum = Integer.parseInt(select);

			System.out.println("선택한 정보를 수정하시겠어요?");
			System.out.print(" 1: Yes    2:No\n =>");

			if (chooseAOrB()) {

				for (int i = 0; i < userList.size(); i++) {
					if (selectNum == userList.get(i).getInfoNumber()) {
						index = i;
						break;
					}
				}

				String name = userList.get(index).getName();

				if (userList.get(index) instanceof PBUnivInfo) {

					System.out.println("이름을 제외한 나머지 정보를 입력해주세요");
					System.out.println("○ 이름 : " + name);
					String phoneNum = inputData("○ 번호");
					System.out.print("○ 생일을 입력해주세요(건너뛰려면 Enter)\\n=> ");
					String birth = input.nextLine().trim();
					if (birth == null || birth.trim().isEmpty()) {
						birth = "(입력없음)";
					}
					String address = inputData("○ 주소");
					String email = inputData("○ 메일");
					String major = inputData("○ 전공");
					String year = inputData("○ 학년");
					System.out.println();

					System.out.print("○ 입력한 정보 \n>>");
					userList.remove(index);
					info = new PBUnivInfo(name, phoneNum, birth, infoNum, address, email, major, year);
					info.showAllData();
					userList.add(info);

				} else if (userList.get(index) instanceof PBCompanyInfo) {
					System.out.println("이름을 제외한 나머지 정보를 입력해주세요");
					System.out.println("○ 이름 : " + name);
					String phoneNum = inputData("○ 번호");
					System.out.print("○ 생일을 입력해주세요(건너뛰려면 Enter)\\n=> ");
					String birth = input.nextLine().trim();
					if (birth == null || birth.trim().isEmpty()) {
						birth = "(입력없음)";
					}
					String email = inputData("○ 메일");
					String company = inputData("○ 직장");
					System.out.println();
					System.out.print("○ 입력한 정보 \n>>");
					info = new PBCompanyInfo(name, phoneNum, birth, infoNum, email, company);
					info.showAllData();
					userList.add(info);
				}

			} else {
				return;
			}
			System.out.println("정보가 수정됐어요");
			return;

		}
	}

	void goToMain() {
		System.out.println();
		System.out.println("★ 메인메뉴로 돌아갈게요.Enter를 눌러주세요★");
		input.nextLine();
	}

}