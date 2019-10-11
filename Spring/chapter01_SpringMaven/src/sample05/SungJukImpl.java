package sample05;

import java.util.Scanner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sJukIm")
@Scope("prototype")
public class SungJukImpl implements SungJuk{

	Scanner input = new Scanner(System.in);
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	
	@Override
	public void calc() {
		
		System.out.print("이름 입력 :");
		this.name = input.nextLine();
		System.out.print("국어 입력 :");
		this.kor = input.nextInt();
		System.out.print("영어 입력 :");
		this.eng = input.nextInt();
		System.out.print("수학 입력 :");
		this.math = input.nextInt();
		this.total = kor+eng+math;
		this.avg = (kor+eng+math)/3;
	}

	@Override
	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "이름\t국어\t영어\t수학\t총점\t평균\n"+this.name+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+this.total+"\t"+this.avg;
	}
	
	
}
