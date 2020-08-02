package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

//<context:component-scan base-package="spring.di.ui"/>
@ComponentScan("spring.di.ui")
@Configuration
public class NewlecDIConfig {

	@Bean
	public Exam exam() {
		return new NewlecExam();
	}
}
