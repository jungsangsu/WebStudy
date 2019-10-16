package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;

@Component
public class HelloSpring {

	public void meue(ApplicationContext context) {
		Scanner input = new Scanner(System.in);
		UserService userService;

		while (true) {
			System.out.println("*************");
			System.out.println("   1.입력");
			System.out.println("   2.출력");
			System.out.println("   3.수정");
			System.out.println("   4.삭제");
			System.out.println("   5.검색");
			System.out.println("   6.종료");
			System.out.println("*************");
			System.out.print("입력번호 : ");

			int number = input.nextInt();

			if (number == 1) {
				userService = context.getBean("userInsertService", UserService.class);
				userService.execute();
			} else if (number == 2) {
				userService = context.getBean("userSelectService", UserService.class);
				userService.execute();
			} else if (number == 3) {
				userService = context.getBean("userUpdateService", UserService.class);
				userService.execute();
			} else if (number == 4) {
				userService = context.getBean("userDeleteService", UserService.class);
				userService.execute();
			} else if(number==5) {
				userService = context.getBean("userSearchService", UserService.class);
				userService.execute();
			}
			else if (number == 6) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}

	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.meue(context);
	}
}
