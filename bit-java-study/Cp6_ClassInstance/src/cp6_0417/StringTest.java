package cp6_0417;

public class StringTest {

	public static void main(String[] args) {
		
		String str1= "My String";
		String str2= "My String";
		String str3= "Your String";
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str2==str3);
		
		
		System.out.println("========================");
		java.lang.String str = "My name is JAVA";
		
		int strLength = str.length();
				
		System.out.println(strLength);
		
		int strLength2= "한글의 길이는?".length();
		System.out.println(strLength2);

	}

}
