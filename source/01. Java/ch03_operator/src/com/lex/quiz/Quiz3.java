package com.lex.quiz;

import java.util.Scanner;

// �μ��� �Է¹޾� �� ���� ������ ����� O�� X�� ���.ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("ù ��° ���� �Է��ϼ���");
		int num1 = sca.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ���");
		int num2 = sca.nextInt();
		if (num1 == num2) {
			System.out.println("O");
		}else {
			System.out.println("X");
		}
		sca.close();
//		String result = (num1 == num2)? "O":"X";
//		System.out.println(result);
	}
}
