package sample03;

import java.util.Scanner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SungJukImpl implements SungJuk{

	@NonNull
	private SungJukDTO sungjukDTO;
	
	@Override
	public void calcTot() {
		sungjukDTO.setTotal(sungjukDTO.getKor()+sungjukDTO.getEng()+sungjukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungjukDTO.setAvg(sungjukDTO.getTotal()/3);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\n"+sungjukDTO.getName()+"\t"+sungjukDTO.getKor()+"\t"+sungjukDTO.getEng()+"\t"+sungjukDTO.getMath()+"\t"+sungjukDTO.getTotal()+"\t"+sungjukDTO.getAvg());
	}

	@Override
	public void modify() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("이름 입력 :");
		sungjukDTO.setName(input.nextLine());
		System.out.print("국어 입력 :");
		sungjukDTO.setKor(input.nextInt());
		System.out.print("영어 입력 :");
		sungjukDTO.setEng(input.nextInt());
		System.out.print("수학 입력 :");
		sungjukDTO.setMath(input.nextInt());
		sungjukDTO.setTotal(sungjukDTO.getKor()+sungjukDTO.getEng()+sungjukDTO.getMath());
		sungjukDTO.setAvg(sungjukDTO.getTotal()/3);
	}
	
}
