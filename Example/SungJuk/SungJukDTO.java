package SungJuk;

public class SungJukDTO {
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private	int sumScore;
	private double avgScore;

	
	public SungJukDTO() {
		this(0,null,0,0,0,0,0);
	}


	public SungJukDTO(int id, String name, int kor, int eng, int math, int sumScore, int avgScore) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sumScore = sumScore;
		this.avgScore = avgScore;
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
		return "SungJukDTO [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", sumScore=" + sumScore + ", avgScore=" + avgScore + "]";
	}
	
	
}
