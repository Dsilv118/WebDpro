package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���

public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-18", "���� ���빮"),
						    new Friend("���浿", "010-8867-4599", "12-19", "���� ����"),
						    new Friend("��浿", "010-9921-9929", "02-10", "���� ���"),
						    new Friend("�ű浿", "010-5129-5539", "03-03", "��õ �۵�")};
		Date birthDay = new Date();
		SimpleDateFormat mont = new SimpleDateFormat("MM-dd");
		String today = mont.format(birthDay);
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�........");
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		}//for
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false; // �Ѹ� �̻� ��� �� none�� false
//			}//if
//		}//for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	}//main
}//class
