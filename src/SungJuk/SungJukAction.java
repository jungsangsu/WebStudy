package SungJuk;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SungJukAction {

	static Scanner input = new Scanner(System.in);
	ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
	String line;
	int num;

	public void SunjuckRun() {

		while (true) {
			meuePrint();
			num = input.nextInt();
			switch (num) {
			case 1:
				insertArticle();
				break;
			case 2:
				printArticle();
				break;
			case 3:
				searchArticle();
				break;
			case 4:
				deleteArticle();
				break;
			case 5:
				sortArticle();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("잘못입력했습니다");
			}
		}

	}

	public void insertArticle() {
		boolean con = true;

		System.out.print("번호입력 : ");
		int num = input.nextInt();

		for (SungJukDTO id : list) {
			if (id.getId() == num)
				con = false;
		}

		if (con) {
			SungJukDTO tempSung = new SungJukDTO();

			tempSung.setId(num);
			System.out.print("이름입력 : ");
			tempSung.setName(input.next());
			System.out.print("국어 입력 :");
			tempSung.setKor(input.nextInt());
			System.out.print("영어 입력 : ");
			tempSung.setEng(input.nextInt());
			System.out.print("수학입력 :");
			tempSung.setMath(input.nextInt());

			int totalScore = tempSung.getKor() + tempSung.getEng() + tempSung.getMath();

			tempSung.setSumScore(totalScore);
			tempSung.setAvgScore((double)totalScore / 3);

			list.add(tempSung);
		} else {
			System.out.println("ID가 중복됩니다.");
		}

	}

	public void printArticle() {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for (SungJukDTO sungJukDTO : list) {
			System.out.println(sungJukDTO.getId() + "\t" + sungJukDTO.getName() + "\t" + sungJukDTO.getKor() + "\t"
					+ sungJukDTO.getEng() + "\t" + sungJukDTO.getMath() + "\t" + sungJukDTO.getSumScore() + "\t"+new DecimalFormat("#.###").format(sungJukDTO.getAvgScore()));


		}
	}

	public void searchArticle() {
		boolean con = false;

		System.out.print("검색 할 이름 입력 :");
		String searchName = input.next();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for (SungJukDTO sungJukDTO : list) {
			if (sungJukDTO.getName().equals(searchName)) {
				con = true;
				System.out.print(sungJukDTO.getId() + "\t" + sungJukDTO.getName() + "\t" + sungJukDTO.getKor() + "\t"
						+ sungJukDTO.getEng() + "\t" + sungJukDTO.getMath() + "\t" + sungJukDTO.getSumScore() + "\t"+
						new DecimalFormat("#.###").format(sungJukDTO.getAvgScore()));
			}
		}
		if (!con) {
			System.out.println("찾고자 하는 이름이 없습니다.");
		}

	}

	public void deleteArticle() {
		boolean con = false;

		System.out.print("삭제 할 이름 입력 :");
		String deleteName = input.next();

		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().compareTo(deleteName) == 0) {
				con = true;
				list.remove(i);
			}
		}
		
		if (!con) {
			System.out.println("삭제하고자 하는 이름이 없습니다.");
		}
		
	}

	public void sortArticle() {

		System.out.println("1. 이름으로 오름차순");
		System.out.println("2. 총점으로 내림차순");
		System.out.println("3. 이전메뉴");
		
		num = input.nextInt();
		
		switch(num)
		{
		case 1:
			Collections.sort(list, (s1,s2) -> s1.getName().compareTo(s2.getName()));
			break;
		case 2:
			Collections.sort(list, (s1,s2) -> s2.getSumScore()- s1.getSumScore() );
			break;
		case 3:
			break;
		default : 
			System.out.println("잘못입력했습니다.");
		}
		
	}

	public void meuePrint() {
		System.out.println("*************\n1. 입력\n2. 출력\n3. 검색\n4. 삭제\n5. 정렬\n6. 끝\n" + "*************\n  번호 : ");
	}

}
