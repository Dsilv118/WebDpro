package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 입력받아 요리조리 별거 다 출력.

public class Ex06_teleNo {
	public static void main(String[] args) {
		String phoneNo; 
		Scanner sca = new Scanner(System.in);
		char temp = 0;
		while(true) {
			System.out.println("전화번호를 입력해 주세요. 종료는 x를 눌러주세요.");
			phoneNo = sca.next(); // 02-369-8745
			// 종료
			if(phoneNo.equalsIgnoreCase("x")) 
				break;
			// 입력한 전화번호 출력
			System.out.println("입력한 전화번호 : " + phoneNo);
			// 짝수번째 문자열
			System.out.print("짝수번째 문자열 : ");
			for(int i=0 ; i<phoneNo.length() ; i++) {
				if(i%2==0) {
					System.out.print(phoneNo.charAt(i)+" ");
				}
			}
			// 문자를 거꾸로
			System.out.println();
			System.out.print("문자를 거꾸로 : ");
			for(int i=phoneNo.length()-1 ; i>=0 ; i--) {
				temp = phoneNo.charAt(i);
				System.out.print(temp);
			}
			// 전번 앞자리
			String front = phoneNo.substring(0, phoneNo.indexOf('-'));
			System.out.println("\n전번 앞자리 : " + front);
			System.out.println();
		}
	}
}
