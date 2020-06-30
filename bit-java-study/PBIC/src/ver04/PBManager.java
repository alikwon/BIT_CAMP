package ver04;

import java.util.Scanner;
// phoneInfo 타입의 배열로 친구들의 정보를
// 저장, 수정, 삭제, 검색, 출력

public class PBManager {
	static Scanner sc;// 밖으로 빼서 반복작업에 용이하게..

	final PhoneInfor[] pBooks; // PhoneInfor 를 참조하는 pBooks배열
	// final을 붙여서 생성자 통해 초기화시 100개 고정

	int cnt;
	PhoneInfor info;

	// 생성자를 통해 초기화 >> PBManager 생성 시 초기화됨
	PBManager(int num) {
		pBooks = new PhoneInfor[num];
		// 1. 참조할 때 반복의 횟수 용도(null일 경우 문제되기때문)
		// 2. 새로운 객체를 저장할 때 index로 사용
		cnt = 0; // 등록된 사용자 정보의 개수
					// 안쓰면 null이 아닌시점으로 쭈우우욱 찾아들어가야 함.

		sc = new Scanner(System.in);
		info = null;
	}
	
	//저장 : 이름, 전화번호, 생년월일 정보를 저장
	//배열에 PhoneInfor 타입의 참조값저장
	void saveInfo(PhoneInfor info) {//생성된 객체를 변수로받아서
		//배열에 요소 대입	
		pBooks[cnt] = info;			//배열에 저장
		
		//등록된 정보의 개수를 증가 시킴.
		cnt++;
	}
	
	// 인스턴스 생성 매서드
	void createInstance() {
		//return new PhoneInfor() 두가지 경우(생일)가 있기때문에 적절하지 못함
		 //인스턴스 변수로 선언하면
		System.out.println("1.일반  2.대학  3.회사  4.동호회");
		System.out.println("입력하실 번호 입력좀요");
		//기본정보 수집 : 이름 , 전번, 주소, 메일
		int select = Integer.parseInt(sc.nextLine().trim());
		if (!(select >0 && select <5)) {
			System.out.println("정상적인 메뉴선택이 아닙니다. \n메뉴를 다시 선택하세요");
			createInstance();
		}
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		
		System.out.println("번호를 입력해주세요 >>");
		String phoneNumber = sc.nextLine();
		
		System.out.println("주소을 입력해주세요 >>");
		String addr = sc.nextLine();
		
		System.out.println("메일을 입력해주세요 >>");
		String email = sc.nextLine();
		
		
		switch(select) {
		case 1:
			//기본 클래스로 인스턴스
			info=new PhoneInfor(name, phoneNumber, addr, email);
			break;
		case 2:
			//대학 클래스로 인스턴스
			System.out.println("전공을 입력해주세요");
			String major = sc.nextLine();
			System.out.println("학년을 입력해주세요");
			String grade = sc.nextLine();
			
			info=new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;
		case 3:
			//회사 클래스로 인스턴스
			System.out.println("회사를 입력해주세요");
			String company = sc.nextLine();
			System.out.println("부서를 입력해주세요");
			String dept = sc.nextLine();
			System.out.println("직급을 입력해주세요");
			String job = sc.nextLine();
			
			info=new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;
		case 4:
			//카페 클래스로 인스턴스
			System.out.println("카페명을 입력해주세요");
			String cafeName = sc.nextLine();
			System.out.println("닉네임을 입력해주세요");
			String nickName = sc.nextLine();
			
			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;			
		}
		saveInfo(info);
		return;
	}
	
	//전체 리스트 출력
	void showAll() {
		
		//전체 데이터 
		//for each 사용하면 안됨(?) >> 공부할 것
		System.out.println("전체 정보를 출력합니다");
		for (int i =0 ; i<cnt;i++) {
			//배열 초기화
			pBooks[i].showAllData();
			System.out.println("----------------");
		}
		
	}
	
	//기본 리스트 출력
	void showBasic() {
		
	}

	//index 검색
	int findIndex(String name) {
		// 배열에서 이름을 기준으로 검색후 index값을 반환 >> find와 del을 합침
		int findIndex=-1;
		
		//String name으로  배열의 요소 검색 ==> index를 찾자
		for (int i=0; i<cnt; i++) {
			if (pBooks[i].checkName(name)) {
				findIndex = i;				
				break;			
			}
		}
		return findIndex;
	}
	
	//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보 출력
	// 배열의 요소 (PhoneInfor) name 속성값으로 요소검색
	void findData() {
		//찾지않으면 데이터가 음수로 유지
		
		System.out.println("검색하실 이름을 입력하세요>>");
		String name = sc.nextLine();
		int findIndex=findIndex(name);
		
		if (findIndex <0)
			System.out.println("찾으시는 데이터가 없습니다");
		else
			pBooks[findIndex].showAllData();
		
	}

	// 삭제 : 
	// pBooks[2]를 삭제한다면
	// pBooks[2]==null; 을 해주면 삭제
	// 아니면 데이터 삭제 후 남아있는 데이터를 빈공란없이 재정리
	void delData() {
		//찾지않으면 데이터가 음수로 유지
				
				System.out.println("삭제하실 이름을 입력하세요>>");
				String name = sc.nextLine();
				int findIndex=findIndex(name);
				
				if (findIndex <0)
					System.out.println("찾으시는 데이터가 없습니다");
				// 검색한 index부터 저장된 위치까지 왼쪽으로 시프트!!!!
				else { 
					for (int i=findIndex; i<cnt-1;i++) {
						pBooks[i] = pBooks[i+1];
					}
					
					//★★저장한 정보 개수 를 -1★★
					cnt--;
					System.out.println("삭제가 완료됐습니다");
				}
				
				
	}

	void editInfo() {
		System.out.println("변경 하고자 하는 이름을 입력해주세요");
		String name = sc.nextLine();
		
		int index = findIndex(name);
		if (index <0) {
			System.out.println("찾으시는 데이터가 없습니다");
			return;
		}
		else {
			
			String editName= pBooks[index].getName();
			
			System.out.println("수정 데이터 입력을 시작합니다");
			System.out.println("이름은 "+editName+"입니다");
			System.out.println("전화번호 입력 해주세요");
			String phoneNumber = sc.nextLine();
			System.out.println("주소 입력 해주세요");
			String addr = sc.nextLine();
			System.out.println("이메일 입력 해주세요");
			String email = sc.nextLine();
			
			PhoneInfor info = null;
			
			//저장된 인스턴스가 : 기본, 대학, 회사, 카페?
			if (pBooks[index] instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력해주세요");
				String major = sc.nextLine();
				System.out.println("학년을 입력해주세요");
				String grade = sc.nextLine();
				
				info = new PhoneUnivInfo(editName, phoneNumber, addr, email, major, grade);
				
			}else if (pBooks[index] instanceof PhoneCompanyInfo) {
				System.out.println("회사를 입력해주세요");
				String company = sc.nextLine();
				System.out.println("부서를 입력해주세요");
				String dept = sc.nextLine();
				System.out.println("직급을 입력해주세요");
				String job = sc.nextLine();
				
				info= new PhoneCompanyInfo(editName, phoneNumber, addr, email, company, dept, job);
				
			}else if (pBooks[index] instanceof PhoneCafeInfo) {
				System.out.println("카페명을 입력해주세요");
				String cafeName = sc.nextLine();
				System.out.println("닉네임을 입력해주세요");
				String nickName = sc.nextLine();
				
				info = new PhoneCafeInfo(editName, phoneNumber, addr, email, cafeName, nickName);
			}else if(pBooks[index] instanceof PhoneInfor) {
				info = new PhoneInfor(editName, phoneNumber, addr, email);
				
			}
			//덮어쓰기
			pBooks[index]= info;
		}
	}
	
















}