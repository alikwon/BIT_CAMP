package emp_dept_management;

public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	//디폴트 생성자 필수 
	public Dept() { 
	}
	
	//매개변수 넣는 생성자는 선택사항
	public Dept(int deptno, String dname, String loc) { 
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}
