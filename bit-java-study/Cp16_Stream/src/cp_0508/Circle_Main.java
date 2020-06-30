package cp_0508;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Circle_Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//객체저장
		FileInputStream fs = new FileInputStream("Object.ser");
		
		// 파일에서 데이더 추출 
		//객체역직렬화 필터스트림
		ObjectInputStream in = new ObjectInputStream(fs);
		
		Circle_Serializable c1 = (Circle_Serializable)in.readObject();
		Circle_Serializable c2 = (Circle_Serializable)in.readObject();
		String string = (String) in.readObject();
		
		c1.showCircleInfo();
		c2.showCircleInfo();
		System.out.println(string);
	}
}
