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
		SimpleDateFormat come = new SimpleDateFormat("yyyy년MM월dd일");
		String well = come.format(date);
		if((depart+"").length() > 10) 
			return "[사번]" + comNo + "\t[이름]" + name + "\t[부서]" + depart + "\t[입사일]" + well;
		else
			return "[사번]" + comNo + "\t[이름]" + name + "\t[부서]" + depart + "\t\t[입사일]" + well;
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
