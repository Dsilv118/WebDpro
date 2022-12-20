package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> frd = new ArrayList<Friend>();
		frd.add(new Friend("홍길동", "서울시 용산구", "010-9999-1234", new Date(new GregorianCalendar(1998, 4, 22).getTimeInMillis())));
		frd.add(new Friend("신길동", "수원시 마포구", "010-9999-9999", new Date(new GregorianCalendar(1995, 11, 10).getTimeInMillis())));
		frd.add(new Friend("임길동", "서울시 강서구", "010-9999-9999", new Date(new GregorianCalendar(1992, 3, 4).getTimeInMillis())));
		frd.add(new Friend("김길동", "인천시 양천구", "010-9921-1334", new Date(new GregorianCalendar(1999, 2, 28).getTimeInMillis())));
		frd.add(new Friend("이길동", "부산시 강서구", "010-9921-1334", new Date(new GregorianCalendar(2002, 10, 25).getTimeInMillis())));
		frd.add(new Friend("양길동", "수원시 양천구", "010-9921-1334", new Date(new GregorianCalendar(2004, 0, 17).getTimeInMillis())));
		Scanner sca = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색하고자 하는 친구의 주소 앞 두글자를 입력해주세요. (종료는x)");
			String arss = sca.next();
			if(arss.equalsIgnoreCase("x"))
				break;
			for(Friend friends : frd) {
				String addr   = friends.getAddress();
				String resadd = addr.substring(0, 2);
				if(arss.equals(resadd)) {
					System.out.println(friends);
					searchOk = true;
				}
			}
			if(! searchOk) {
				System.out.println("해당 지역의 친구는 없습니다");
			}
		}
		sca.close();
	}
}
