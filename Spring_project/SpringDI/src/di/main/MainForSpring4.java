package di.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.service.ChangePasswordService2;
import di.service.MemberRegisterService2;

public class MainForSpring4 {
	
	private static GenericXmlApplicationContext ctx = null;
	
	//Bean 객체의 범위 Scope 
	// --> default = singleton
	//(appCtx7.xml)
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx7.xml");
		
		MemberRegisterService2 mrService1 = ctx.getBean("memberregSvc",MemberRegisterService2.class);
		MemberRegisterService2 mrService2 = ctx.getBean("memberregSvc",MemberRegisterService2.class);
		boolean chk1 = mrService1==mrService2;
		System.out.println("Scope(prototype) : "+chk1);
		
		ChangePasswordService2 cpService1 = ctx.getBean("memberPwSvc",ChangePasswordService2.class);
		ChangePasswordService2 cpService2 = ctx.getBean("memberPwSvc",ChangePasswordService2.class);
		boolean chk2 = cpService1==cpService2;
		System.out.println("Scope(singleton) : "+chk2);
	}

}
