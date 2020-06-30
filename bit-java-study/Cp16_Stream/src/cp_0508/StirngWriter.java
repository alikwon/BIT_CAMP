package cp_0508;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StirngWriter {
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("news.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("손흥민 해병대 입대!!");
		bw.newLine();
		bw.write("살좀빼자");
		bw.newLine();
		bw.write("메롱끝");
		
		bw.close();
		
		System.out.println("끄으읏");
	}
}
