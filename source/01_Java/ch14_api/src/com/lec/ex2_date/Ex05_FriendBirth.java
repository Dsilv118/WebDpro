package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

// ���� ������ ģ���� ���

public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮"),
						    new Friend("���浿", "010-8867-4599", "12-14", "���� ����"),
						    new Friend("��浿", "010-9921-9929", "02-10", "���� ���"),
						    new Friend("�ű浿", "010-5129-5539", "03-03", "��õ �۵�")};
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1; // 12
		int day   = now.get(Calendar.DAY_OF_MONTH); // 14
//		String monthStr = month<10 ? "0"+month : ""+month;
		String monthStr = month<10 ? "0"+month : String.valueOf(month); 
		String dayStr = day<10 ? "0"+day : String.valueOf(day);
		String today = monthStr + "-" + dayStr;
		System.out.println(today);
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�");
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false; // �Ѹ� �̻� ��� �� none�� false
			}//if
		}//for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	}//main
}//class
