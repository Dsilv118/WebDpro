package com.lec.quiz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(nowDate);
		ArrayList<Member> mem = new ArrayList<Member>();
		Scanner sca = new Scanner(System.in);
		int year, month, day;
		Date birth = null;
		do {
			System.out.println("회원가입을 진행하려면 아무키나 눌러주세요 (종료는 x)");
			String end = sca.next();
			if(end.equalsIgnoreCase("x"))
				break;
			System.out.println("회원님의 이름을 입력해주세요");
			String temp1 = sca.next();
			System.out.println("회원님의 전화번호를 입력해주세요");
			String temp2 = sca.next();
			System.out.println("회원님의 생일을 양식에 맞게 입력해주세요 (양식 : 1998-01-18)");
			String temp3 = sca.next();
			StringTokenizer toke = new StringTokenizer(temp3, "-");
			if(toke.countTokens() == 3) {
				year = Integer.parseInt(toke.nextToken());
				month = Integer.parseInt(toke.nextToken());
				day = Integer.parseInt(toke.nextToken());
				birth = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
				temp3 = temp3.substring(temp3.indexOf("-")+1);
				if(temp3.equals(today)) {
					System.out.println("생일 축하합니다!");
				}
			} else {
				System.out.println("생일 정보가 올바르지 않습니다.");
			}
			System.out.println("회원님의 주소를 입력해주세요");
			sca.nextLine();
			String temp4 = sca.nextLine();
			mem.add(new Member(temp1, temp2, birth, temp4));
		}while(true);
		sca.close();
		OutputStream write = null;
		try {
			write = new FileOutputStream("src/com/lec/quiz/member.txt");
			for(Member member : mem) {
				System.out.print(member);
				byte[] bs = (member.toString()).getBytes();
				write.write(bs);
			}
			String msg = String.format("\t\t\t.... 이하 %d명 가입", mem.size());
			System.out.println(msg);
			byte[] bs = msg.getBytes();
			write.write(bs);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(write!=null)
						write.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
