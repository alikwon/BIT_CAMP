package cp11_interface;

public class PersonalNumberStorageImpl 
//					extends PersonalNumberStorage {
					implements PersonalNumInter {

	PersonalNumberInfo[] perArr;
	int numOfPerInfo; //저장된 정보개수
	
	PersonalNumberStorageImpl(int num) {
		perArr = new PersonalNumberInfo[num];
		numOfPerInfo = 0;
	}
	
	
	//추상메서드 override
	@Override
	public void addPersonalInfo(String perNum, String name) {
		perArr[numOfPerInfo]=new PersonalNumberInfo(name, perNum);
		numOfPerInfo++;
	}

	@Override
	public String searchName(String perNum) {
		for (int i=0; i<numOfPerInfo;i++) {
			
			//문자열의 비교는 compareTo 쓰지않음 마이너스 연산
//			if (perNum.compareTo(perArr[i].getNumber())==0) {
			if (perArr[i].getNumber().equals(perNum)) {
				return perArr[i].getName();
			}
		}
		return null;
	}

}
