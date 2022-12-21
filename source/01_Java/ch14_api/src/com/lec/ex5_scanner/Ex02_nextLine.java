package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("주소는 : ");
		//sca.nextLine();
		String address = sca.nextLine();
		System.out.println("입력하신 주소는 " + address);
		System.out.print("나이 : ");
		int age = sca.nextInt();
		System.out.println("나이는 " + age);
		System.out.print("이름 : ");
		// 현재 버퍼에 "\n"이 있는 상태
		sca.nextLine(); // 버퍼 지우기 목적
		String name = sca.nextLine();
		System.out.println("입력한 이름은 " + name);
		System.out.println("프로그램 긑");
	}
}
