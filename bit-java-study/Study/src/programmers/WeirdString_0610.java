package programmers;

public class WeirdString_0610 {

	public String mySolution(String s) {
		String answer="";
		String[] arr = s.split("");
		int a=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(" ")) {
				a=0;
			} else {
				System.out.println(i+""+a);
				if (a % 2 == 0) {
					arr[i]=arr[i].toUpperCase();
					a++;
				}else {
					arr[i]=arr[i].toLowerCase();
					a++;
				}

			}
			answer+=arr[i];
		}
		return answer;
	}
	
	//삼항연산자를 쓰니 확실히 코드가 간편해 보인다.
	public String otherSolution(String s) {
		String answer ="";
		int cnt = 0;
		String []arr = s.split("");
		
		for(String a : arr) {
			// contains : 포함하고 있으면 true
			cnt = a.contains(" ") ? 0: ++cnt;
			answer += cnt%2==0? a.toLowerCase():a.toUpperCase();
		}
		return answer;
	}

	public static void main(String[] args) {
		WeirdString_0610 ws= new WeirdString_0610();
		String s = "asdf asdf aqwer vgzc hg qhba b";
		System.out.println(ws.mySolution(s));
		
	}

}
