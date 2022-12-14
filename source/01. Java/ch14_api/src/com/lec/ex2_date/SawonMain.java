package com.lec.ex2_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon[] sawons = {new Sawon("A2012", "홍길동", Sawon.COMPUTER),
						  new Sawon("A2450", "김길동", Sawon.PLANNING, 2022, 12,5),
						  new Sawon("A2029", "신길동", Sawon.DESIGN, 2022,12,5),
						  new Sawon("A2123", "임길동", Sawon.ACCOUNTING, 2022,12,5),
						  new Sawon("A5213", "남길동", Sawon.HUMANRESOURCES, 2022,12,5)};

		for(Sawon sawon : sawons) {
			System.out.println(sawon);
		}
		
	}

}
