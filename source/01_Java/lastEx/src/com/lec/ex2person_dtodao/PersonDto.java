package com.lec.ex2person_dtodao;

// 입력용 : 이름, 직업명, 국, 영, 수 vs 출력용 : rw, 이름("홍길동(1번)"), 직업명, 국, 영, 수, 합

public class PersonDto {
	private String rw;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int scr;
	public PersonDto() {}
	// 입력용 : 이름, 직업명, 국, 영, 수
	public PersonDto(String pname, String jname, int kor, int eng, int mat) {
		super();
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	// 출력용 : rw, 이름("홍길동(1번)"), 직업명, 국, 영, 수, 합
	public PersonDto(String rw, String pname, String jname, int kor, int eng, int mat, int scr) {
		super();
		this.rw = rw;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.scr = scr;
	}
	@Override
	public String toString() {
		return rw + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + scr;
	}
	public String getrw() {
		return rw;
	}
	public void setrw(String rw) {
		this.rw = rw;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
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
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getscr() {
		return scr;
	}
	public void setscr(int scr) {
		this.scr = scr;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	public int getScr() {
		return scr;
	}
	public void setScr(int scr) {
		this.scr = scr;
	}
}
