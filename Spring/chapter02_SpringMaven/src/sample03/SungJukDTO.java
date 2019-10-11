package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;

import lombok.Getter;
import lombok.Setter;

//@Component
@ComponentScan("com.conf")
@Getter
@Setter
public class SungJukDTO {
	@Value("홍길동")
	private String name;
	private @Value("97") int kor;
	private @Value("100") int eng;
	private @Value("95") int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+String.format("%.3f", avg);
	}
	
}
