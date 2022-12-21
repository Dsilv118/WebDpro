package com.lec.quiz;

public class Customer {
	private String name;
	private String pno;
	private String adress;
	
	public Customer() {}
	public Customer(String name, String pno, String adress) {
		this.name = name;
		this.pno = pno;
		this.adress = adress;
	}
	
	@Override
	public String toString() {
		return name + "\t" + pno + "\t" + adress;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
