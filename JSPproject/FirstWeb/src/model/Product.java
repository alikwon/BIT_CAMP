package model;

public class Product {
	private String[] productList = {
			"java","HTML5","CSS","javascript","JSP"
	};
	
	private int num1 = 10;
	private int num2 = 20;
	
	
	public String[] getProductList() {
		return productList;
	}
	public void setProductList(String[] productList) {
		this.productList = productList;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public boolean getCheck() {
		return true;
	}
	
}
