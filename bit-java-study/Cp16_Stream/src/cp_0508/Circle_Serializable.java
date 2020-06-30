package cp_0508;

import java.io.Serializable;

public class Circle_Serializable implements Serializable {

	int xPos;
	int yPos;
	double rad;

	public Circle_Serializable(int xPos, int yPos, double rad) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rad = rad;
	}

	void showCircleInfo() {
		System.out.println("xPos : " + xPos + ", yPos : " + yPos);
		System.out.println("rad : " + rad);
	}

}
