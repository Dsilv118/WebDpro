package com.lec.ex;

public class Student {
	private String num;
	private String name;
	private int    grade;
	private char   clss;
	private int    score;
	
	public Student() {}
	public Student(String num, String name, int grade, char clss, int score) {
		this.num = num;
		this.name = name;
		this.grade = grade;
		this.clss = clss;
		this.score = score;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getClss() {
		return clss;
	}
	public void setClss(char clss) {
		this.clss = clss;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
