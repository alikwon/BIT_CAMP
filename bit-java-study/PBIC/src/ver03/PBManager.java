package ver03;

import java.util.Scanner;
/*	
	Project : ver 0.30

	배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 
	
	아래기능 삽입
	
	저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
	
	데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
	재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
	
	검색, 삭제 : phoneInfo 에서 동작한다고 착각하면 안됨
*/


public class PBManager {
	static Scanner sc;// 밖으로 빼서 반복작업에 용이하게..

	final PhoneInfor[] pBooks; // PhoneInfor 를 참조하는 pBooks배열
	// final을 붙여서 생성자 통해 초기화시 100개 고정

	int cnt;
	PhoneInfor info;

	// 생성자를 통해 초기화 >> PBManager 생성 시 초기화됨
	public PBManager() {
		pBooks = new PhoneInfor[100];
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
	
	//creatInstance 와 saveInfo 를 동시에
	void saveInfo() {
		
		pBooks[cnt] = createInstance(); //후위형 증감연산자를 통해서 코드를 줄임			
		
		cnt++;
	}
	
	
	//사용자의 입력으로 PhoneInfor 객체를 생성 후 객체 반환
	PhoneInfor createInstance() {// 인스턴스 생성 매서드
		//return new PhoneInfor() 두가지 경우(생일)가 있기때문에 적절하지 못함
		 //인스턴스 변수로 선언하면
		
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		
		System.out.println("번호를 입력해주세요 >>");
		String phoneNumber = sc.nextLine();// nextLine은 한 줄 끝까지
		
		System.out.println("생일을 입력해주세요 >>");
		String birthday = sc.nextLine();
		
		
		//사용자의 입력데이터에 따라 인스턴스 생성 구분
		// birth가 null이거나 공백 제거 후 비어있다면
		if(birthday ==null || birthday.trim().isEmpty()) { //trim() = 공백제거
			info = new PhoneInfor(name, phoneNumber);
		}else {
			info = new PhoneInfor(name, phoneNumber, birthday);
		}
		
		return info;	//info객체 반환
	}
	
	
	//전체 리스트 출력
	void showAll() {
		
		//전체 데이터 ==> 입력된 정보의 개수 ==> cnt만큼 출력
		for (int i =0; i<cnt; i++) {
			//배열 초기화
			pBooks[i].showData();
			System.out.println("----------------");
		}
		
	}

	//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보 출력
	// 배열의 요소 (PhoneInfor) name 속성값으로 요소검색
	void findData() {
		//찾지않으면 데이터가 음수로 유지
		int findIndex=-1;
		
		System.out.println("검색하실 이름을 입력하세요>>");
		String name = sc.nextLine();
			
		//String name으로  배열의 요소 검색 ==> index를 찾자
		for (int i=0; i<cnt; i++) {
			if (pBooks[i].checkName(name)) {// 이 단계에서 Infor의 name을 가져올수없음==> private
				findIndex = i;				// checkName을 만들어줌
				break;			//동명이인 고려안함 첫번째 데이터에서 break
			}
		}
		if (findIndex <0)
			System.out.println("찾으시는 데이터가 없습니다");
		else
			pBooks[findIndex].showData();
		
	}
	// 배열에서 이름을 기준으로 검색후 index값을 반환 >> find와 del을 합침
	int findIndex(String name) {
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

	// 삭제 : 
	// pBooks[2]를 삭제한다면
	// pBooks[2]==null; 을 해주면 삭제
	// 아니면 데이터 삭제 후 남아있는 데이터를 빈공란없이 재정리
	void delData() {
		//찾지않으면 데이터가 음수로 유지
				int findIndex=-1;
				
				System.out.println("삭제하실 이름을 입력하세요>>");
				String name = sc.nextLine();
					
				//String name으로  배열의 요소 검색 ==> index를 찾자
				for (int i=0; i<cnt; i++) {
					if (pBooks[i].checkName(name)) {
						findIndex = i;				
						break;			
					}
				}
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

	
















}