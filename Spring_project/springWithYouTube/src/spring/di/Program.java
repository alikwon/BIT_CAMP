package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.ui.ExamConsole;

public class Program {
	
	public static void main(String[] args) {
		
		/* 주입을 스프링에게 지시하는 방법으로 코드를변경
		Exam exam = new NewlecExam();
		
		//Exam 객체(부품)를 이리저리 꽂아줌(주입)
		// --> 이것을 대신해주는것이 스프링
		ExamConsole console = new InlineExamConsole(exam);//DI
		ExamConsole console = new GridExamConsole(exam);//DI
		
		console.setExam(exam);
		*/
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		//ExamConsole console = (ExamConsole) context.getBean("console");
		//getBean으로 가져오게 되면 싱글턴을 보장 
		ExamConsole console = context.getBean("console",ExamConsole.class);
		console.print(); 
		
		
	}
}
