package com.lex.quiz;

import java.util.Scanner;

//����, ����, ���� ������ ����ڿ��� �Է¹޾�, �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("���� ������ �Է��ϼ���");
		int kor = sca.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		int eng = sca.nextInt();
		System.out.println("���� ������ �Է��ϼ���");
		int math = sca.nextInt();
		int all = (kor + eng + math);
		double avg = (all/3.0);
		System.out.println("������" + all);
		System.out.printf("����� %.2f\n", avg);
		sca.close();
	}
}
