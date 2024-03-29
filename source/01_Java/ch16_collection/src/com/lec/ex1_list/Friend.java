package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel; 
	private Date birthday;
	
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date birthday) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}
	@Override
	public String toString() { //Friend f = new Friend("ȫ", "010-2221-2223");
		                       // sysout(f) => ȫ 717-2231
		if(birthday!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E����)");
			return "name=" + name + ", tel=" + tel + ", birthday=" + sdf.format(birthday);
		}else {
			return "name=" + name + ", tel=" + tel;
		}
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public Date getBirthday() {
		return birthday;
	}
	
	
}
