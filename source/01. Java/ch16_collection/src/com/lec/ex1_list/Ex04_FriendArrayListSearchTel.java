package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex04_FriendArrayListSearchTel {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-2314-2231"));
		friends.add(new Friend("신길동", "010-2314-2231", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("임길동", "02-214-2241"));
		Scanner sca = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("검색하고자 하는 전화번호 뒷자리? (종료는 x)");
			String searchTel = sca.next(); // 9999
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(Friend friend : friends) {
				String tel = friend.getTel();
				String postTel = tel.substring(tel.lastIndexOf("-")+1);
				if(searchTel.equals(postTel)) {
					System.out.println(friend);
					searchOk = true;
				}
			}//for
			if(! searchOk) {
				System.out.println("검색하신 전화번호 뒷자리는 없습니다.");
			}
		}
	}
}
