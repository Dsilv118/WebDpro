package com.lec.ex2_date;

public class SawonMain2 {
	public static void main(String[] args) {
		Sawon2[] sawons = {new Sawon2("A2012", "ȫ�浿", Dept.COMPUTER),
						  new Sawon2("A2450", "��浿", Dept.PLANNING, 2022, 12,5),
						  new Sawon2("A2029", "�ű浿", Dept.DESIGN, 2022,12,5),
						  new Sawon2("A2123", "�ӱ浿", Dept.ACCOUNTING, 2022,12,5),
						  new Sawon2("A5213", "���浿", Dept.HUMANRESOURCES, 2022,12,5)};

		for(Sawon2 sawon : sawons) {
			System.out.println(sawon);
		}
		
	}

}
