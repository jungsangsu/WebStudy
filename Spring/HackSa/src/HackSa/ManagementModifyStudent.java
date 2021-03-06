package HackSa;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.conf")
public class ManagementModifyStudent implements Management {

	@Autowired
	private ArrayList<StudentDTO> list;

	@Override
	public void execute(ApplicationContext context) {
		Scanner input = new Scanner(System.in);
		int sw = 0;

		System.out.println("수정할 이름을 입력하세요");
		String name = input.next();

		for (StudentDTO sungJukDTO2 : list) {
			if (sungJukDTO2.getName().equals(name)) {
				System.out.println(sungJukDTO2);
				sw++;
				
				System.out.println();
				System.out.println(name+"님의 데이터 수정을 시작합니다...");
				System.out.print("국어 입력 : ");
				sungJukDTO2.setKor(input.nextInt());
				System.out.print("영어 입력 : ");
				sungJukDTO2.setEng(input.nextInt());
				System.out.print("수학 입력 : ");
				sungJukDTO2.setMath(input.nextInt());
				sungJukDTO2.setTotal(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.getMath());
				sungJukDTO2.setAvg(sungJukDTO2.getTotal()/3);
			}
		}

		if (sw == 0)
		{
			System.out.println("수정할 이름이 없습니다.");
		}
	}

}
