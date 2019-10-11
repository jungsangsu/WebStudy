package HackSa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.conf")
public class ManagementSortStudent implements Management {

	@Autowired
	private ArrayList<StudentDTO> list;

	@Override
	public void execute(ApplicationContext context) {
		list = (ArrayList<StudentDTO>) list.stream().sorted((s1, s2) -> (s1.getTotal()-s2.getTotal()));

	}

}
