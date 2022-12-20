package com.lec.quiz;

public class Member {
	private String name;
	private String pno;
	private String birth;
	private String address;
	
	public Member() {}
	public Member(String name, String pno, String birth, String address) {
		this.name = name;
		this.pno = pno;
		this.birth = birth;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return name + pno + birth + address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
