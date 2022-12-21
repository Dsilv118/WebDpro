package com.lec.ex2_date;

public class SawonMain2 {
	public static void main(String[] args) {
		Sawon2[] sawons = {new Sawon2("A2012", "홍길동", Dept.COMPUTER),
						  new Sawon2("A2450", "김길동", Dept.PLANNING, 2022, 12,5),
						  new Sawon2("A2029", "신길동", Dept.DESIGN, 2022,12,5),
						  new Sawon2("A2123", "임길동", Dept.ACCOUNTING, 2022,12,5),
						  new Sawon2("A5213", "남길동", Dept.HUMANRESOURCES, 2022,12,5)};

		for(Sawon2 sawon : sawons) {
			System.out.println(sawon);
		}
		
	}

}
