package test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PrinterMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Printer printer = ctx.getBean("printer", Printer.class);
		
		printer.print();
	}

}
