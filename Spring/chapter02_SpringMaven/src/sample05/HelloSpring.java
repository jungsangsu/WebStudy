package sample05;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample05.SungJuk;

@ComponentScan("com.conf") //이건 config파일로 리스트 가지고 오려고 사용
public class HelloSpring {
	
	
	/*
	 * @Autowired ArrayList<SungJukDTO2> list;
	 */
	
	public void meue(ApplicationContext context) {
		
		boolean condition = true;
		Scanner input = new Scanner(System.in);
		SungJuk sungJuk;
		
		while (condition) {
			System.out.println("*************");
			System.out.println("   1.입력");
			System.out.println("   2.수정");
			System.out.println("   3.삭제");
			System.out.println("   4.출력");
			System.out.println("   5.종료");
			System.out.println("*************");
			System.out.print("입력번호 : ");
			int num = input.nextInt();

			
			switch (num) {
			case 1:
				sungJuk = context.getBean("sungJukInput",SungJuk.class);
				sungJuk.execute();
				break;
			case 2:
				sungJuk = context.getBean("sungJukModify",SungJuk.class);
				sungJuk.execute();
				break;
			case 3:
				sungJuk = context.getBean("sungJukDelete",SungJuk.class);
				sungJuk.execute();
				break;
			case 4:
				sungJuk = context.getBean("sungJukOutput",SungJuk.class);
				sungJuk.execute();
				break;
			case 5:
				condition = false;
				break;
			default:
				break;
			}
			
		}

	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring",HelloSpring.class);
		helloSpring.meue(context);
	}
}
