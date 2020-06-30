package cp_0508;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Circle_Main2 {

	public static void main(String[] args) throws IOException {
		
		//객체저장
		FileOutputStream fs = new FileOutputStream("Object.ser");
		
		//객체저장 필터스트림
		ObjectOutputStream out = new ObjectOutputStream(fs);
		
		out.writeObject(new Circle_Serializable(1,2,1.2));
		out.writeObject(new Circle_Serializable(3,6,3.6));
		out.writeObject(new String("String implements Serializable"));
		out.close();
		
		System.out.println("인스턴스 데이터 저장");
	}
}
