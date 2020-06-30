package cp15_0506;

import javax.swing.JOptionPane;

public class SingleThread {

	public static void main(String[] args) {

		System.out.println("프로그램 시작함요");

		String input = JOptionPane.showInputDialog("당신 이름 입력좀요");
		System.out.println("니가 적은 이름 : " + input);

		//countdown
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
