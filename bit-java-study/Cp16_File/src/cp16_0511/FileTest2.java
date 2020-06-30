package cp16_0511;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {

		// 폴더경로 객체 생성
		File myDir = new File("c:\\myJava");
		
		// 파일 이름을 배열에 저장
		String[] fNames = myDir.list();

		// 폴더안의 파일리스트 출력
		for (int i=0;i<fNames.length;i++) {
			System.out.println(fNames[i]);
		}

		// 파일 객체로 배열에 저장
		File[] files = myDir.listFiles();
		for(int i=0; i< files.length; i++) {
			//디렉토리인지 아닌지 
			if (files[i].isDirectory()) {
				System.out.print("[DIR]\t");
			}else
				System.out.print("[FILE]\t");
			System.out.println(files[i].getName());
		}
	}
}
