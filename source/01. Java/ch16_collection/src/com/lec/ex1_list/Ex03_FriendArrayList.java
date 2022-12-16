package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_FriendArrayList {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-2314-2231"));
		friends.add(new Friend("�ű浿", "010-2314-2231", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("�ӱ浿", "02-214-2231"));
		for(int i=0 ; i<friends.size() ; i++) {
			System.out.println(friends.get(i));
		}
		System.out.println("��ȭ��ȣ�� ���");
		for(int i=0 ; i<friends.size() ; i++) {
			System.out.println(friends.get(i).getTel());
		}
		for(Friend friend : friends) {
			System.out.println(friend.getTel());
		}
	}
}
