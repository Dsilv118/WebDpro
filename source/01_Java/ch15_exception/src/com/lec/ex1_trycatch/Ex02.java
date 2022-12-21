package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int i, j; // ����ڿ��� �Է¹��� ���� ����
		System.out.print("ù��° ������?");
		i = sca.nextInt();
		System.out.print("�ι�° ������?");
		j = sca.nextInt();
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		try {
			System.out.println("i / j = " + (i/j)); // ���ܰ� �߻��� ���� �ִ� �κ�
		}catch(ArithmeticException e) { // ���ܹ߻��� ���� �κ�
			System.out.println(e.getMessage()); // ���ܸ޼��� ��� 
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		sca.close();
	}
}