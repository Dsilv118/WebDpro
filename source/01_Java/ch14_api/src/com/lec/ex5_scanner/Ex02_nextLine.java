package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02_nextLine {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("�ּҴ� : ");
		//sca.nextLine();
		String address = sca.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� " + address);
		System.out.print("���� : ");
		int age = sca.nextInt();
		System.out.println("���̴� " + age);
		System.out.print("�̸� : ");
		// ���� ���ۿ� "\n"�� �ִ� ����
		sca.nextLine(); // ���� ����� ����
		String name = sca.nextLine();
		System.out.println("�Է��� �̸��� " + name);
		System.out.println("���α׷� �P");
	}
}
