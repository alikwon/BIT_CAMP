package cp17_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkTest3 {
	
	public static void main(String[] args) throws IOException {
		
		URL url = null;
		String address = "https://cafe.naver.com/aiajr202003.cafe?iframe_url=/MyCafeIntro.nhn?clubid=30056261";
		BufferedReader input = null;
		url = new URL(address);
		String line = "";
		
		try {
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while(true) {
				
				line = input.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			
			input.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
