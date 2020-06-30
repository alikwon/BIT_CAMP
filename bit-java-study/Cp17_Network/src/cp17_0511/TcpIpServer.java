package cp17_0511;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {
		
		ServerSocket sS = null;
		
		try {
			sS = new ServerSocket(7777);
			System.out.println("소켓 서버가 준비됐어영");	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//클라이언트에서 소켓 연결 요청이 올 때 까지 대기
		while(true) {
			System.out.println("연결 요청 대기중이영");
			
			//요청이 들어오면 연결 소켓 생성
			try {
				Socket socket = sS.accept();// 요청이 올때까지 대기
				System.out.println(socket.getInetAddress()+"로부터 연결요청이 왔어영");
				
				//출력스트림을 socket객체로 부터 얻는다
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//클라이언트 소켓으로 데이터 전송
				dos.writeUTF("[Notice] Test Message from Server");
				System.out.println("데이터 전송했어영");
				
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
		
		}
		
		
	}
}
