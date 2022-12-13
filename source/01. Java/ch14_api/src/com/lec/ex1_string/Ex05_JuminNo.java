package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_JuminNo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num;
		char wom;
		System.out.println("주민번호를 입력하세요");
		num = scan.next();
		num.charAt(7);
		wom = num.charAt(7);
		if (wom=='1' || wom=='3') {
			System.out.println("남자입니다");
		} else if (wom=='2' || wom=='4') {
			System.out.println("여자입니다");
		} else {
			System.out.println("주민번호가 아닙니다");
		}
//      방법 3. wom을 정수로 전환         정수스트링을 정수로 ("2"을 2로)
//		int womInt = Integer.parseInt(wom);   
//		if(womInt==1 || womInt==3) {
//			System.out.println("남성이시군요");
//		} else if (womInt==2 || womInt==4) {
//			System.out.println("여성이시군요");
//		} else {
//			System.out.println("유효하지 않은 주민번호입니다");
//		}
	}
}
