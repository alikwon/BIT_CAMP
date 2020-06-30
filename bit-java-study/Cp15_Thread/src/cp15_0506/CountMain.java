package cp15_0506;

import javax.swing.JOptionPane;

public class CountMain {

	public static void main(String[] args) {

		System.out.println("프로그램 시작함요");

		CountThread ct = new CountThread();
		ct.start();
		
		String input = JOptionPane.showInputDialog("당신 이름 입력좀요");
		
		System.out.println("니가 적은 이름 : " + input);

	}
}
