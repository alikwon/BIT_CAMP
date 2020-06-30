
package version05;

/* 
 	< 개선할 사항 > 
	- 검색시 입력한 이름정보가 없을때 saveData? 물어보면 좋을듯
		==> 이름은 입력안하게 하려면 인스턴스 생성 매서드 & saveData 매서드 오버라이딩??
	  
	- 검색된 이름정보에서 삭제나 수정으로 넘어가면 좋을듯 
	
	- 대학친구에서 추가된 사항들을 필수 입력사항이 아닌 선택입력사항으로 .. 
		>> 생성자 매개변수 개수가 너무 많음 >> 빌더패턴???
		>> creatInstance 메서드 안에서 if사용해서 대입해주면 끝...
	
	- 검색시 기본, 대학, 카테고리 별로 검색해도 좋을듯
		>> 2차원배열? 
		>> 기본 - 1, 2, 3, 4 
		>> 대학 - 1, 2, 3, 4
		>> 회사
		
	
 */

/* Project ver 0.50
	PhoneBookManager 클래스의 인스턴스수가 최대 하나를 넘지 않도록 코드를
	변경.
	‘initerface’기반의 상수 표현을 바탕으로 메뉴 선택과 그에 따른 처리가, 
	이름에 부여된 상 수를 기반으로 진행되도록 변경.
	
	PhoneInfor 클래스의 구조에서 “interface”를 추가하여 “추상 클래스”로 구성해봅시다
	이 인터페이스에는 오버라이딩을 위한 메서드만 포함하는 인터페이스로 구성합니다.

 */
import java.util.Scanner;

public class PBManager {

	// 2. 클래스 내부에서 공동으로 사용할 인스턴스 생성
	private static PBManager manager = new PBManager();

	// 3. 인스턴스의 참조변수를 반환하는 메서드
	public static PBManager getInstance() {
		return manager;
	}
	
	static Scanner input = new Scanner(System.in);
	final PBInfo[] userList;
//	private ArrayList<PBInfo> userList;
	PBInfo info;
	static int count;
	PBInfo[] searchList; // 검색결과가 여러명일때 슬거
//	ArrayList<PBInfo> searchData;
	
	// 1. 생성자 접근지시자 private 을 붙인다.
	private PBManager() {
		userList = new PBInfo[100];
		searchList = new PBInfo[100];
//		userList = new ArrayList<PBInfo>();
//		searchData = new ArrayList<PBInfo>();
		count = 0;
		info = null;
	}


	// 이지선다 >> 참거짓 반환
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

	// 입력시 반드시 입력해야한다라는 기능을 따로 메서드 만듦 >> 유저가 입력한 값 반환
	String inputData(String data) {
		String str = null;
		System.out.print(data + "을(를) 입력 해주세요 \n=> ");

		try {
			str = input.nextLine().trim();
			// 입력이 없을때다시 입력해야함 >> trim() = 공백제거
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

		// 선택: 2. 대학정보 3. 회사정보
		int choiceNum = 0;
		while (true) {
		System.out.println("1.대학정보    2.회사정보");
		System.out.print(" ==> ");
			try {
				choiceNum = Integer.parseInt(input.nextLine().trim());
				if (!(choiceNum == 2 || choiceNum == 1)) {
					throw new MyException();
				}else 
					break;
			} catch (NumberFormatException e) {
				System.out.println("★ 잘못된 입력이에요★");
				continue;
			} catch (MyException e) {
				System.out.println("★ 메뉴의 번호는 2번까지 밖에 없어요 ★");
				continue;
			}
		}

		// 공통정보
		// 이름입력
		name = inputData("○ 이름");
		// 번호입력
		phoneNum = inputData("○ 번호");
		// 생일 입력
		System.out.print("○ 생일을 입력해주세요(건너뛰려면 Enter)\n=> ");
		birth = input.nextLine().trim();
		if (birth == null || birth.trim().isEmpty()) {
			birth = "(입력없음)";
		}
		switch (choiceNum) {
//		case 1:
//			System.out.println();
//			System.out.print("○ 입력한 정보 \n>>");
//			info = new PBInfo(name, phoneNum, birth);
//			info.showAllData();
//			break;
		case 1:
			address = inputData("○ 주소");
			email = inputData("○ 메일");
			major = inputData("○ 전공");
			year = inputData("○ 학년");
			System.out.println();
			System.out.print("○ 입력한 정보 \n>>");
			info = new PBUnivInfo(name, phoneNum, birth, address, email, major, year);
			info.showAllData();
			break;
		case 2:
			email = inputData("○ 메일");
			company = inputData("○ 직장");
			System.out.println();
			System.out.print("○ 입력한 정보 \n>>");
			info = new PBCompanyInfo(name, phoneNum, birth, email, company);
			info.showAllData();

		}
		System.out.println();
		System.out.println("- 입력하신 정보가 맞나요?");
		System.out.print(" 1: Yes    2:No\n =>");
		if (chooseAOrB()) {
			saveData(info);
			return;// 생성된 객체 반환
		} else {
			System.out.println("다시 입력해주세요");
			createInstance();
		}
	}

	// 생성된 인스턴스 저장
	void saveData(PBInfo pBInfo) {
		userList[count] = pBInfo;
		count++;
		System.out.println("★★ 정보가 저장됐어요 ★★");
	}

	// 전체 정보 출력
	void showAll() {
		if (count == 0) {
			System.out.println("( 저장된 이름이 하나도 없어요 )");
			return;
		}

		// 기본정보 : 이름 전번 생일 (Univ 와 Company의 경우 메일까지)
		System.out.print("1: 기본정보보기    2: 상세정보보기\n =>");
		if (chooseAOrB()) { // 1을 선택했을 때
			for (int i = 0; i < count; i++) {
				System.out.print("[");
				System.out.print(i + 1 + "]");
				userList[i].showBasicData();
			}
		} else { // 2를 선택했을 때
			for (int i = 0; i < count; i++) {
				System.out.print("[");
				System.out.print(i + 1 + "]  ");
				userList[i].showAllData();
			}
		}
		System.out.println("----------------------");
		System.out.println("○ 현재 저장된 번호 개수: " + count);
	}

	// 검색 : 이름을 기준으로 데이터 검색 > 이름입력받
	// 배열의 요소들의 name값을 검색
	int searchData() {
		// 이름 입력
		String name = inputData("이름");
		// 입력한 이름으로 검색된 개수 받고
		int searchCnt = 0;
		for (int i = 0; i < count; i++) {
			if (userList[i].checkName(name)) { // boolean
				searchList[searchCnt] = userList[i];// 이름이 같으면 배열에 넣어줌
				searchCnt += 1;
			}
		}

		if (searchCnt == 0) {
			System.out.println("입력하신 이름의 정보는 없어요");
			System.out.println();
			System.out.println("다시 검색하시겠어요?");
			System.out.print(" 1: Yes    2:No\n =>");
			if (chooseAOrB()) {
				searchData(); // 다시 검색기능 불러오기
			} else {
				return searchCnt;
			}
			// 1명이상일때
		} else {
			// 검색된 이름의 개수 출력
			System.out.println();
			System.out.println("  ★★ 검색결과 ★★");
			System.out.println("○ 입력하신 이름으로 " + searchCnt + "명 검색됐어요");
			// 검색된 개수 만큼 정보 출력

			for (int i = 0; i < searchCnt; i++) {
				System.out.print("[");
				System.out.print(i + 1 + "]  ");
				searchList[i].showAllData();
			}
		}

		return searchCnt;
	}// 삭제할때 검색을 수행해주기 위해 searchCount 반환

	void delData() {

		// 1명일때와 2명이상일때를 구분해야함
		// >>1명은바로 삭제하시겠습니까
		// >>2명이상은 삭제를 원하는 이름을 고르고 나서 , 삭제하시겠습니까 >>
		String select = null;
		int index = 0;

		// 검색을 먼저 한뒤에 삭제 >>
		int searchCnt = searchData();

		// 2명이상이면 번호선택
		if (searchCnt > 1) {
			while (true) {
				System.out.print("삭제하실 이름의 ");
				select = inputData("번호");
				if (Integer.parseInt(select) > searchCnt) {
					System.out.print("잘못된 번호에요. 다시 입력하세요\n=> ");
					continue;
				} else
					break;
			}
		} else if (searchCnt == 1) {
			select = "1";
		}
		int selectNum = Integer.parseInt(select);

		// 삭제하시겠어요?
		System.out.println("정말로 삭제하시겠어요?");
		System.out.print(" 1: Yes    2:No\n =>");
		// 삭제시 고유번호를 비교해서 삭제
		if (chooseAOrB()) {

			// 선택한 이름의 고유번호와 전체 목록의 고유번호 비교 후 삭제
			for (int i = 0; i < count; i++) {
				if (searchList[selectNum - 1].getInfoNumber() == userList[i].getInfoNumber()) {
					index = i;
					break;
				}
			}
			for (int i = index; i < count - 1; i++) {
				userList[i] = userList[i + 1];
				userList[i].setInfoNumber(); // 고유번호도 다시매겨줌
			}

			System.out.println("★★ 정보가 삭제 됐어요 ★★");
			count--;
		} else
			return;
	}

	// 정보 수정 메서드
	void editData() {
		// 1.우선 수정할 데이터를 이름으로 검색 후
		// 2.이름이 여러개면 수정할 이름을 고름
		// 3.고른 이름의 인덱스 값을 찾고  ==> 여기까진 정보삭제와 동일
		// 4.이름은 남겨두고 나머지 값을 입력받은 뒤
		// 5.해당 인덱스에 덮어 씌우기
		String select = null;
		int index = 0;

		// 1. 우선 이름으로 검색 --> searchData 메서드 불러옴
		// searchCnt ==> 검색된 이름의 개수
		int searchCnt = searchData();

		// 2.1 이름이 여러개일 때
		if (searchCnt > 1) {
			while (true) {
				System.out.print("수정하실 이름의 ");

				// 2.2 수정할 이름의 번호를 입력
				select = inputData("번호");
				if (Integer.parseInt(select) > searchCnt) {
					System.out.print("잘못된 번호에요. 다시 입력하세요\n=> ");
					continue;
				} else
					break;
			}
			// 2.3 이름이 한개일 때
		} else if (searchCnt == 1) {
			select = "1";
		}
		// 2.4 선택한 번호 (String)을 int로 형변환
		int selectNum = Integer.parseInt(select);

		System.out.println("선택한 이름을 수정하시겠어요?");
		System.out.print(" 1: Yes    2:No\n =>");

		// 3.1 고른이름의 인덱스 값을 찾기
		if (chooseAOrB()) {

			// 3.2 인덱스를 찾았고
			for (int i = 0; i < count; i++) {
				if (searchList[selectNum - 1].getInfoNumber() == 
										userList[i].getInfoNumber()) {
					index = i;
					break;
				}
			}
			// 3.3 선택된 인덱스 객체의 이름은 고정
			String name = userList[index].getName();

			// 3.4 해당 객체가 Univ 인지 Company 인지판단후
			if (userList[index] instanceof PBUnivInfo) {
				// 3.5 이름을 제외한 입력값으로 객체생성
				System.out.println("이름을 제외한 나머지 정보를 입력해주세요");
				System.out.println("○ 이름 : " + name);
				String phoneNum = inputData("○ 번호");
				System.out.print("○ 생일을 입력해주세요(건너뛰려면 Enter)\n=> ");
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
				userList[index] = new PBUnivInfo(name, phoneNum, birth, 
												 address, email, major, year);
				userList[index].showAllData();

			} else if (userList[index] instanceof PBCompanyInfo) {
				System.out.println("이름을 제외한 나머지 정보를 입력해주세요");
				System.out.println("○ 이름 : " + name);
				String phoneNum = inputData("○ 번호");
				System.out.print("○ 생일을 입력해주세요(건너뛰려면 Enter)\n=> ");
				String birth = input.nextLine().trim();
				if (birth == null || birth.trim().isEmpty()) {
					birth = "(입력없음)";
				}
				String email = inputData("○ 메일");
				String company = inputData("○ 직장");
				System.out.println();

				System.out.print("○ 입력한 정보 \n>>");
				userList[index] = new PBCompanyInfo(name, phoneNum, 
													birth, email, company);
				userList[index].showAllData();
			}

		} else {
			return;
		}
		System.out.println("★★ 정보가 수정됐어요 ★★");
		return;
	}

	// 메인으로 돌아가는거
	void goToMain() {
		System.out.println();
		System.out.println("★ 메인메뉴로 돌아갈게요.Enter를 눌러주세요★");
		input.nextLine();
	}

}