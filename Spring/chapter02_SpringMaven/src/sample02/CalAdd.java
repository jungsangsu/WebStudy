package sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalAdd implements Calc {

	//private @Value("25") int x;
	//private @Value("36") int y;
	private int x,y;
	
	public CalAdd(@Value("25")int x, @Value("25")int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void calculate() {
		System.out.println(this.x+"+"+this.y+"="+(this.x+this.y));
	}

}
