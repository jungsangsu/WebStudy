package sample05;

import java.util.ArrayList;
import lombok.Setter;


@Setter
public class SungJukOutput implements SungJuk {
	private ArrayList<SungJukDTO2> arraylist;
	@Override
	public void execute() {
		for (SungJukDTO2 sungJukDTO2 : arraylist) {
			System.out.println(sungJukDTO2.toString());
		}
	}

	
}
