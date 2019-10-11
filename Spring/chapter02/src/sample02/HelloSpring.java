package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc c = context.getBean("calcAdd",Calc.class);
		c.calculate();
		c = context.getBean("calcMul",Calc.class);
		c.calculate();
	}
}
