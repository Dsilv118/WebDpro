package com.lec.ex09_customer;

public class Person {
	private String name;
	private String num; // Person p = new Person("ȫ�浿", "010-9999-9999");
	public Person(String name, String num) {
		this.name = name;
		this.num = num;
	}
	public String infoString() {
		return "[�̸�]"+ name +"   [��ȭ]" + num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
