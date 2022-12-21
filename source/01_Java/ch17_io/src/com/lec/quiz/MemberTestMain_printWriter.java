package com.lec.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_printWriter {
	public static void main(String[] args) {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(nowDate);
		ArrayList<Member> mem = new ArrayList<Member>();
		Scanner sca = new Scanner(System.in);
		int year, month, day;
		Date birth = null;
		while(true) {
			System.out.println("ȸ�������� �����Ϸ��� �ƹ�Ű�� �����ּ��� (����� x)");
			String end = sca.next();
			if(end.equalsIgnoreCase("x"))
				break;
			System.out.println("ȸ������ �̸��� �Է����ּ���");
			String temp1 = sca.next();
			System.out.println("ȸ������ ��ȭ��ȣ�� �Է����ּ���");
			String temp2 = sca.next();
			System.out.println("ȸ������ ������ ��Ŀ� �°� �Է����ּ��� (��� : 1998-01-18)");
			String temp3 = sca.next();
			StringTokenizer toke = new StringTokenizer(temp3, "-");
			if(toke.countTokens() == 3) {
				year = Integer.parseInt(toke.nextToken());
				month = Integer.parseInt(toke.nextToken());
				day = Integer.parseInt(toke.nextToken());
				birth = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
				temp3 = temp3.substring(temp3.indexOf("-")+1);
				if(temp3.equals(today)) {
					System.out.println("���� �����մϴ�!");
				}
			} else {
				System.out.println("���� ������ �ùٸ��� �ʽ��ϴ�.");
			}
			System.out.println("ȸ������ �ּҸ� �Է����ּ���");
			sca.nextLine();
			String temp4 = sca.nextLine();
			mem.add(new Member(temp1, temp2, birth, temp4));
		}
		sca.close();
		PrintWriter write = null;
		try {
			write = new PrintWriter("src/com/lec/quiz/member.txt");
			for(Member member : mem) {
				System.out.print(member);
				write.print(member);
			}
			String msg = String.format("\t\t\t.... ���� %d�� ����", mem.size());
			System.out.println(msg);
			write.print(msg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(write!=null)
						write.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
