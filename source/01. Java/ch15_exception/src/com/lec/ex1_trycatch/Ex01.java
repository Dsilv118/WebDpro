package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int i, j=1; // ����ڿ��� �Է¹��� ���� ����
		System.out.print("ù��° ������?");
		do {
			try {
				i = sca.nextInt();
				break;
			}catch (InputMismatchException e) {
				System.out.println("���� ���ڸ� ���� ������");
				sca.nextLine(); // ���۸� ����� ����
			}
		}while(true);
		System.out.print("�ι�° ������?");
		try {
			j = sca.nextInt();
			System.out.println("i / j = " + (i/j)); // ���ܰ� �߻��� ���� �ִ� �κ�
		}catch(ArithmeticException e) { // ���ܹ߻��� ���� �κ�
			// System.out.println(e.getMessage()); // ���ܸ޼��� ��� 
			e.printStackTrace();
		}
		catch(InputMismatchException e) {
			System.out.println("���� �޼��� : " + e.getMessage());
			System.out.println("�ι�° ������ �Է��ϼż� 1�� �մϴ�");
		}
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		sca.close();
	}
}
