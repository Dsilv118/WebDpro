package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String pno;
	private Date birth;
	private String address;
	
	public Member() {}
	public Member(String name, String pno, Date birth, String address) {
		this.name = name;
		this.pno = pno;
		this.birth = birth;
		this.address = address;
	}
	
	@Override
	public String toString() {
		if(birth!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			return name + "\t" + pno + "\t" + sdf.format(birth) + "\t" + address + "\n";
		} else {
			return name + "\t" + pno + "\t" + "생일모름" + "\t" + address + "\n";
		}
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
