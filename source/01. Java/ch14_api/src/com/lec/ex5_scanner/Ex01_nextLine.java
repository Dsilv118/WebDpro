package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("���� : ");
		int age = sca.nextInt();
		System.out.println("�Է��� ���̴� " + age + "��");
		System.out.print("�̸� : ");
		String name = sca.next();
		System.out.println("�Է��� �̸��� " + name);
		System.out.print("�ּ� : ");
		sca.nextLine();// ���ۿ� ���� �ִ� "\n"�� �����
		String address = sca.nextLine(); // "\n" ���� ���� return�ϰ� "\n"�ڴ� ������
		System.out.println("�Է��� �ּҴ� " + address);
		System.out.println("����");
		sca.close();
	}
}
