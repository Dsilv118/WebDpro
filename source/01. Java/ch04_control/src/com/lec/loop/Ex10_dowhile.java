package com.lec.loop;

import java.util.Scanner;

// ¦���� �Է¹޾� ���
public class Ex10_dowhile {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int num;
		do {
			System.out.println("¦���� �Է��ϼ��� :");
			num = sca.nextInt();
		}while(num%2!=0);
		System.out.println("�Է��� ¦����" + num);
		sca.close();
	}
	

}
