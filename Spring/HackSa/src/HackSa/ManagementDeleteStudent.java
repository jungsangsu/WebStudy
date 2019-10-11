package HackSa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.conf")
public class ManagementDeleteStudent implements Management {

	@Autowired
	private ArrayList<StudentDTO> list;

	@Override
	public void execute(ApplicationContext context) {
		Scanner input = new Scanner(System.in);
		int sw = 0;

		System.out.println("삭제할 이름을 입력하세요");
		String name = input.next();
		Iterator<StudentDTO> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().getName().equals(name)) {
				it.remove();
				sw = 1;
			}
		} // for

		if (sw == 0) {
			System.out.println("삭제할 이름이 없습니다.");
		}
	}

}
