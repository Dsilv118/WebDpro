package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ �Է¹޾� �丮���� ���� �� ���.

public class Ex06_teleNo {
	public static void main(String[] args) {
		String phoneNo; 
		Scanner sca = new Scanner(System.in);
		char temp = 0;
		while(true) {
			System.out.println("��ȭ��ȣ�� �Է��� �ּ���. ����� x�� �����ּ���.");
			phoneNo = sca.next(); // 02-369-8745
			// ����
			if(phoneNo.equalsIgnoreCase("x")) 
				break;
			// �Է��� ��ȭ��ȣ ���
			System.out.println("�Է��� ��ȭ��ȣ : " + phoneNo);
			// ¦����° ���ڿ�
			System.out.print("¦����° ���ڿ� : ");
			for(int i=0 ; i<phoneNo.length() ; i++) {
				if(i%2==0) {
					System.out.print(phoneNo.charAt(i)+" ");
				}
			}
			// ���ڸ� �Ųٷ�
			System.out.println();
			System.out.print("���ڸ� �Ųٷ� : ");
			for(int i=phoneNo.length()-1 ; i>=0 ; i--) {
				temp = phoneNo.charAt(i);
				System.out.print(temp);
			}
			// ���� ���ڸ�
			String front = phoneNo.substring(0, phoneNo.indexOf('-'));
			System.out.println("\n���� ���ڸ� : " + front);
			System.out.println();
		}
	}
}
