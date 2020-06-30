package cp_0508;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy2 {
	public static void main(String[] args) {// throws IOException{
		InputStream in = null;
		OutputStream out = null;
		int copyByte = 0;
		int readLeng;
		byte[] buf = new byte[1024];

		try {
			in = new FileInputStream("test.txt");
			out = new FileOutputStream("copy.txt");
			while (true) {

				readLeng = in.read(buf);
				if (readLeng == -1) {
					break;
				}
				out.write(buf,0,readLeng);
				copyByte+=readLeng;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("복사된 바이트 크기 : " + copyByte);

	}
}
