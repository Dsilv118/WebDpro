package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {
	
	private String comNo;
	private String name;
	private Dept depart;
	private Date date;
	
	public Sawon2(String comNo, String name, Dept depart) {
		this.comNo = comNo;
		this.name = name;
		this.depart = depart;
		date = new Date();
	}

	public Sawon2(String comNo, String name, Dept depart, int y, int m, int d) {
		this.comNo = comNo;
		this.name = name;
		this.depart = depart;
		date = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	
	@Override
	public String toString() {
		SimpleDateFormat come = new SimpleDateFormat("yyyy��MM��dd��");
		String well = come.format(date);
		if((depart+"").length() > 10) 
			return "[���]" + comNo + "\t[�̸�]" + name + "\t[�μ�]" + depart + "\t[�Ի���]" + well;
		else
			return "[���]" + comNo + "\t[�̸�]" + name + "\t[�μ�]" + depart + "\t\t[�Ի���]" + well;
	}

	public String getComNo() {
		return comNo;
	}

	public String getName() {
		return name;
	}

	public Dept getDepart() {
		return depart;
	}

}
