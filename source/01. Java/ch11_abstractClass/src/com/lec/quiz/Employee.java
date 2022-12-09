package com.lec.quiz;

public abstract class Employee {
	// 데이터
	private String name;

	public Employee(String name) {
		this.name = name;
	}
	// 생성자
	public final int computeincentive() {
		if(computePay() >= 3000000) {
			return (int)(computePay()*0.05);
		}
		return  0;
	}
	public abstract int computePay();
	// Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
