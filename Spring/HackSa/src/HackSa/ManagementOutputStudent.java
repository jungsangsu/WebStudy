package HackSa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.conf")
public class ManagementOutputStudent implements Management{

	@Autowired
	private ArrayList<StudentDTO> list;
	
	@Override
	public void execute(ApplicationContext context) {
		for (StudentDTO studentDTO : list) {
			System.out.println(studentDTO.toString());
		}
	}

}
