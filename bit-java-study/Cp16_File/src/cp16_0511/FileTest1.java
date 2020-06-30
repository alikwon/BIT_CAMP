package cp16_0511;

import java.io.File;

public class FileTest1 {
	
	public static void main(String[] args) {
		
//		File myFile = new File ("c:\\myJava\\test.txt");
//		File myFile = new File ("c:\\myJava","test.txt");
		//구분자
		File myFile = new File ("c:"+File.separator+"myJava"+File.separator+"test.txt");		
		
		//파일 존재유무확인
		if(!(myFile.exists())) {
			System.out.println("파일이 없어염");
			return;
		}
		
		//새로운 폴더 생성
		File reDir = new File("c:\\yourJava");
		reDir.mkdir();
		
		//새로운 파일 경로 생성
		File newFile = new File(reDir,"new.txt");
		myFile.renameTo(newFile);
		
		if (newFile.exists()) {
			System.out.println("파일이 이동됐어염");
		} else {
			System.out.println("파일 이동실패에염");
		}
		
	}

}
