package com.lec.quiz;

public class Staff extends Person {
	private String department;
	private static int num=0;
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		num++;
		setNo("staff"+num);
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(°ú¸ñ)"+department;
	}
}

