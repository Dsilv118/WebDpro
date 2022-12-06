package com.lec.quiz;
// 객체 생성 : new Student("정우성", 90, 80, 100); -> 번호, 총점, 평균도 같이 초기화
// 데이터 : 번호, 이름, 국, 영, 수, 총, 평 
public class Student {
	private static int num=1;
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int avg;
	public Student() {}
	public Student(String name, int kor, int eng, int math) {
		no = num++;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot = kor + eng + math;
		avg = tot/3;
	}
	public String score() {
		return String.format("\t%d\t%s\t%d\t%d\t%d\t%d\t%d",no, name, kor, eng, math, tot, avg);
	}
	public int getNum() {
		return num;
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	
}
