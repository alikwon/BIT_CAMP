package cp_0508;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy3 {
	public static void main(String[] args) {// throws IOException{
		InputStream in = null;
		OutputStream out = null;
		BufferedInputStream bin =null;
		BufferedOutputStream bout=null;
		int copyByte = 0;
		int bData;

		try {
			in = new FileInputStream("test.txt");
			out = new FileOutputStream("copy.txt");
			//필터스트림 생성
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);
			
			while (true) {

				bData = bin.read();
				if (bData == -1) {
					break;
				}
				bout.write(bData);
				copyByte++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bin.close();
				bout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("복사된 바이트 크기 : " + copyByte);

	}
}
