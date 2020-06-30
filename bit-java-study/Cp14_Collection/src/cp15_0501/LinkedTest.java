package cp15_0501;

public class LinkedTest {

	public static void main(String[] args) {
		String str1 = "one";
		String str2 = "two";
		String str3 = "three";
		String str4 = "four";
		
		Data d1 = new Data(str1,str2);
		Data d2 = new Data(str2,str3);
		Data d3 = new Data(str3,str4);
		Data d4 = new Data(str4,null);
		
		d1.setNextValue(str3); // d2삭제
		
		
	}

}


class Data{
	
	Object value;		//값
	Object nextValue;	//다음 주소값
	
	Data(Object obj,Object nextObj) {
		this.value = obj;
		this.nextValue = nextObj;
	}
	
	Object getValue () {
		return value;
	}
	
	void setNextValue(Object nextValue) {
		this.nextValue = nextValue;
	}
}