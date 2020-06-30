package emp_dept_management;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		EmpManager em = new EmpManager();
		DeptManager dm = new DeptManager();
		while(true) {
			System.out.println("==============================");
			System.out.println("1. Emp관리\t2.Dept관리\t3.종료");
			System.out.println("==============================");
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:
				System.out.println("==============================");
				System.out.print("1.사원입력\n");
				System.out.print("2.사원수정\n");
				System.out.print("3.사원삭제\n");
				System.out.print("4.사원리스트\n");
				System.out.print("5.사원검색\n");
				System.out.print("6.메인으로\n");
				System.out.println("==============================");
				int empSelect = Integer.parseInt(sc.nextLine());
				switch(empSelect) {
				case 1:
					em.empInput();
					break;
				case 2:
					em.empEdit();
					break;
				case 3:
					em.empDelete();
					break;
				case 4:
					em.empList();
					break;
				case 5:
					em.empSearch();
					break;
				case 6:
					continue;
				}
				break;
			case 2:
				System.out.println("==============================");
				System.out.print("1.부서입력\n");
				System.out.print("2.부서수정\n");
				System.out.print("3.부서삭제\n");
				System.out.print("4.부서리스트\n");
				System.out.print("5.부서검색\n");
				System.out.print("6.메인으로\n");
				System.out.println("==============================");
				int deptSelect = Integer.parseInt(sc.nextLine());
				switch(deptSelect) {
				case 1:
					// 사용자의 입력데이터 dept 객체에 담아서 dao insert메서드로 전달
//					dm.deptInput();
					break;
				case 2:
					dm.deptEdit();
					break;
				case 3:
					// 이름 또는 부서번호 dao delete 쪽으로 전달하기
					dm.deptDelete();
					break;
				case 4:
					dm.deptList();
					break;
				case 5:
					// 사용자가 입력한 이름을 dao search에 전달
					dm.deptSearch();
					break;
				case 6:
					continue;
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
				break;
			}
		}
	}

}
