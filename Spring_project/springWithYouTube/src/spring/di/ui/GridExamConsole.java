package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")//bean의 id를 정해주는것과 같음
public class GridExamConsole implements ExamConsole {

	@Autowired
	//@Qualifier("exam2")
	private Exam exam;
	
	public GridExamConsole(Exam exam) {
		System.out.println("오버로드 생성자");
		this.exam=exam;
	}
	
	public GridExamConsole() {
		System.out.println("기본생성자");
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("┌───────────┬───────────┐");
		System.out.println("│   total   │    avg    │");
		System.out.println("├───────────┼───────────┤");
		if(exam!=null)
			System.out.printf("│    %3d    │   %3.2f   │\n",exam.total(),exam.avg());
		else
			System.out.printf("│    %3d    │   %3.2f   │\n",0,0.0);
		System.out.println("└───────────┴───────────┘");
	}
	
	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		System.out.println("setter");
		this.exam=exam;
	}

}
