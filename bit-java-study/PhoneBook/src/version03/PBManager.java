
package version03;
 
import java.util.Scanner;

import version03.PBInfo;
 
class PBManager {
    static Scanner input = new Scanner(System.in);
    final PBInfo [] userList;
    PBInfo info;
    static int count;
    PBInfo [] searchList;
    
    public PBManager() {
        userList = new PBInfo[100];
        count=0;
        info = null;
        searchList =new PBInfo[100];
    }
    
    void saveData() {

        //정보입력을 잘못했을때를 위해 반복문사용
        Loop1:while (true) {
            System.out.print(" - 이름을 입력하세요 >>");
            String name = input.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("※ 이름은 반드시 입력하셔야 합니다. 다시 입력하세요 ※");
                continue;
            }
            
            System.out.print(" - 전화 번호를 입력하세요 >>");
            String num = input.nextLine();
            if (num == null || num.trim().isEmpty()) {
                System.out.println("※전화번호는 반드시 입력하셔야 합니다. 다시 입력하세요※");
                continue;
            }
            
            System.out.print(" - 생일을 입력하세요.(스킵은 엔터) >>");
            String birth = input.nextLine();
            
            System.out.println("---------------------------");
            System.out.println("< 입력하신 정보 >");
            System.out.println(": 이름 : " + name + ", 번호 : " + num + ", 생일: " + birth);
            System.out.println("---------------------------");
            
            System.out.println("※ 입력하신 정보가 맞습니까?");
            while(true) {
                System.out.println("  Yes : 1 , 다시입력 : 2 , 메인메뉴 : 3");
                String answer = input.nextLine();
    
                if (answer.equals("1")) {
                    if (birth == null || birth.trim().isEmpty()) {
                        info = new PBInfo(name, num);
                    } else {
                        info = new PBInfo(name, num, birth);
                    }
                    userList[count] = info;
                    count++;
                    System.out.println("★ 저장이 완료 되었습니다 ★");
                    goToMain();
                    return;
                } else if (answer.equals("2"))
                    continue Loop1;
                else if (answer.equals("3"))
                    return;
                else {
                    System.out.println("잘못된 입력입니다");
                }
            }
        }
    }
    
 
    void showAll() {
        for (int i = 0; i < count; i++) {
            userList[i].showData();
            
        }
        System.out.println("----------------------");
        System.out.println("현재 저장된 번호 개수: "+count);
        goToMain();
    }
 
    int searchData() {
    	int scnt=0;
        while (true) {
            String name = input.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("※ 반드시 입력하셔야 합니다 ※");
                continue;
            }
            System.out.println("---------------------------");
            System.out.println("< 검색 결과 >");
            scnt = indexSearch(name);
            if (scnt == 0) {
                System.out.println("※ 검색된 정보가 없습니다 ※");
                goToMain();
                break;
            }else if (scnt==1){
                searchList[0].showData();
                return scnt;
            }
            else {
            	System.out.println(" "+scnt+"명이 검색되었습니다");
                for (int i = 0; i<scnt;i++) {
                	searchList[i].showData();
                }
                break;
            }
        }
        return scnt;
    }
    
	void delData() {
		
		int sNum;
		int scnt = searchData();
		if (scnt > 0) {
			while (true) {
				System.out.println("정말 삭제하시려면 삭제하실 이름의 번호를 정확히 입력하세요");
				String ans = input.nextLine();
				sNum = Integer.parseInt(ans);
				if (ans == null || ans.trim().isEmpty()) {
					System.out.println("※ 반드시 입력하셔야 합니다 ※");
					continue;
				} else {
					for (int i = sNum - 1; i < count - 1; i++) {
						userList[i] = userList[i + 1];
						userList[i].number--;
					}
					count--;
				}
				System.out.println("★ 삭제되었습니다 ★");
				goToMain();
				return;
			}
		}
	}

    //메인으로 돌아가는거
    void goToMain()    { 
        System.out.println("---------------------------");
        System.out.println("메뉴로 돌아 갑니다. 엔터를 누르세요");
        input.nextLine();
        System.out.println();
    }
    
    
    int indexSearch(String name) {
        
        int scnt=0;
        for (int i = 0; i < count; i++) {
            if (userList[i].getName().equals(name)) {
                searchList[scnt]=userList[i];//이름이 같으면 다른 배열에 넣어줌
                scnt+=1;          
            }
        }
        return scnt;//입력과 이름이 같은사람 수 반환
    }
    
}