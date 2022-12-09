package com.lec.quiz;

public class Gangsa extends Person {
	private String subject;
	private static int num=0;
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		num++;
		setNo("gangsa"+num);
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(ºÎ¼­)"+subject;
	}
}
