package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> frd = new ArrayList<Friend>();
		frd.add(new Friend("ȫ�浿", "����� ��걸", "010-9999-1234", new Date(new GregorianCalendar(1998, 4, 22).getTimeInMillis())));
		frd.add(new Friend("�ű浿", "������ ������", "010-9999-9999", new Date(new GregorianCalendar(1995, 11, 10).getTimeInMillis())));
		frd.add(new Friend("�ӱ浿", "����� ������", "010-9999-9999", new Date(new GregorianCalendar(1992, 3, 4).getTimeInMillis())));
		frd.add(new Friend("��浿", "��õ�� ��õ��", "010-9921-1334", new Date(new GregorianCalendar(1999, 2, 28).getTimeInMillis())));
		frd.add(new Friend("�̱浿", "�λ�� ������", "010-9921-1334", new Date(new GregorianCalendar(2002, 10, 25).getTimeInMillis())));
		frd.add(new Friend("��浿", "������ ��õ��", "010-9921-1334", new Date(new GregorianCalendar(2004, 0, 17).getTimeInMillis())));
		Scanner sca = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��ϰ��� �ϴ� ģ���� �ּ� �� �α��ڸ� �Է����ּ���. (�����x)");
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
				System.out.println("�ش� ������ ģ���� �����ϴ�");
			}
		}
		sca.close();
	}
}
