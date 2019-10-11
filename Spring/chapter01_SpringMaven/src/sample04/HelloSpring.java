package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc c = (Calc) context.getBean("cAdd", Calc.class);
		c.calculate(25, 26);
		
		c = (Calc) context.getBean("cMul");
		c.calculate(25, 36);
	
		((AbstractApplicationContext) context).close();
	}

}
