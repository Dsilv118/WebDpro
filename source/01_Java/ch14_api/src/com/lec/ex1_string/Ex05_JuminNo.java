package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_JuminNo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num;
		char wom;
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		num = scan.next();
		num.charAt(7);
		wom = num.charAt(7);
		if (wom=='1' || wom=='3') {
			System.out.println("�����Դϴ�");
		} else if (wom=='2' || wom=='4') {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("�ֹι�ȣ�� �ƴմϴ�");
		}
//      ��� 3. wom�� ������ ��ȯ         ������Ʈ���� ������ ("2"�� 2��)
//		int womInt = Integer.parseInt(wom);   
//		if(womInt==1 || womInt==3) {
//			System.out.println("�����̽ñ���");
//		} else if (womInt==2 || womInt==4) {
//			System.out.println("�����̽ñ���");
//		} else {
//			System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�");
//		}
	}
}
