package hacksa;

import java.io.Serializable;

public class ScoreDTO implements Serializable, Comparable<ScoreDTO>{

	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private	int sumScore;
	private double avgScore;
	
	public ScoreDTO(int id, String name, int kor, int eng, int math, int sumScore, double avgScore) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sumScore = sumScore;
		this.avgScore = avgScore;
	}

	public ScoreDTO() {
		this(0,null,0,0,0,0,0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	@Override
	public String toString() {
		return String.format("%5s %5s %4d %4d %4d %4d %5.1f",this.id,this.name,this.kor,this.eng,this.math,this.sumScore,this.avgScore );
	}
	
	@Override
	public int compareTo(ScoreDTO o) {
		if(this.getSumScore()<o.getSumScore())
		{
			return -1;
		}
		else {
			return 1;
		}
	}
	
}
