package com.lec.condition;

import java.util.Scanner;

// �Է¹��� ���� Ȧ������ ¦������ ���
public class Ex06 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���");
		int num = sca.nextInt();
		switch (num%2) {
		case 0:
			System.out.println("¦���Դϴ�"); break;			
		default:
			System.out.println("Ȧ���Դϴ�");
			break;
		}
	}

}
