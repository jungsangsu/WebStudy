package sample03;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
public class SungJukDTO {
	
	private String name;
	private int kor,eng,math;
	private int total;
	private double avg;
	
}
