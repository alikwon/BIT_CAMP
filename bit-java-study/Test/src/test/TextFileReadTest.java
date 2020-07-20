package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReadTest {
	public static void main(String[] args) {
		File textFile = new File("C:\\Users\\ALi_Kwon\\Desktop\\message.txt");
		FileReader filereader;
		String x ="너구리";
		String y ="호랑이";
		try {
			filereader = new FileReader(textFile);
			//입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			String [] a = null;
			while((line = bufReader.readLine()) != null){
				a = line.split(":");
				if(Integer.parseInt(a[0])==1) {
					System.out.print(x+" : ");
					System.out.println(a[1]);
				}else {
					System.out.print(y+" : ");
					System.out.println(a[1]);
				}
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
