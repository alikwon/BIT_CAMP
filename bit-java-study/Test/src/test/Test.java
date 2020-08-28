package test;
// 냉장고
public class Test {
	public static void main(String[] args) {
		
		int[] a = {6,5,4,3,2,1,0,0,1,2,3,4,5,6};
		int max = 3;
		System.out.println(calcDays(max,a));
	}
	
	public static int calcDays(int max, int[] a) {
		int day=0;
		int work = 0;
		for(int i =0;i<a.length;i++) {
			if(work!=0 || a[i]!=0) {
				day++;
			}
			work+=a[i]-max;
			if (work<=0) {
				work=0;
			}
		}
		if(work>0) {
			if(work%max==0) {
				day+=work/max;
			}
			else {
				day+=work/max +1;
			}
		}
		return day;
	}
}
