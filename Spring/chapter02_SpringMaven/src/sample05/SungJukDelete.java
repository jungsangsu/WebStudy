package sample05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import lombok.Setter;

@Setter
public class SungJukDelete implements SungJuk {

	private ArrayList<SungJukDTO2> arraylist;

	@Override
	public void execute() {
		Scanner input = new Scanner(System.in);
		int sw = 0;

		System.out.println("삭제할 이름을 입력하세요");
		String name = input.next();
		Iterator<SungJukDTO2> it = arraylist.iterator();
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
