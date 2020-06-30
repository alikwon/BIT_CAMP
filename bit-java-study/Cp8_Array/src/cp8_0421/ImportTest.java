package cp8_0421;

import java.text.SimpleDateFormat;
import java.util.Date; //date클래스를 import

public class ImportTest {
	public static void main(String[] args) {
		//Date 클래스 
		//java.util.Date
		//날짜와 시간정보를 하나로 표현
		Date today = new Date();
		//컴퓨터 시계를 가져옴
		
		System.out.println(today);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy. MM. dd. a HH:mm:ss");
		//H 대문자 24시 기준
		//M 대문자 월 , 소문자 시
		
		SimpleDateFormat date = new SimpleDateFormat();
		System.out.println(date.format(today));
		System.out.println(dateFormat.format(today));
	}
}
