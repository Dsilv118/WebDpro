package com.lec.ex2_date;

public class SawonMain {
	public static void main(String[] args) {
		Sawon[] sawons = {new Sawon("A2012", "ȫ�浿", Sawon.COMPUTER),
						  new Sawon("A2450", "��浿", Sawon.PLANNING, 2022, 12,5),
						  new Sawon("A2029", "�ű浿", Sawon.DESIGN, 2022,12,5),
						  new Sawon("A2123", "�ӱ浿", Sawon.ACCOUNTING, 2022,12,5),
						  new Sawon("A5213", "���浿", Sawon.HUMANRESOURCES, 2022,12,5)};

		for(Sawon sawon : sawons) {
			System.out.println(sawon);
		}
		
	}

}
