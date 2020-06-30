package cp_0508;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {
	public static void main(String[] args) {// throws IOException{
		InputStream in = null;
		OutputStream out = null;
		int copyByte = 0;
		int bData;

		try {
			in = new FileInputStream("test.txt");
			out = new FileOutputStream("copy.txt");
			while (true) {

				bData = in.read();
				if (bData == -1) {
					break;
				}
				out.write(bData);
				copyByte++;
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
