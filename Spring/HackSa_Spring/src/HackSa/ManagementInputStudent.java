package HackSa;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.conf")
public class ManagementInputStudent implements Management {

	@Autowired
	private ArrayList<StudentDTO> list;
	
	@Override
	public void execute() {
		StudentDTO s = new StudentDTO();
		s.setKor(100);
		
		list.add(s);
		System.out.println(list.size());
	}

}
