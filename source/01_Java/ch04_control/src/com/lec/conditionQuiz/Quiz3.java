package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2)�� �ϳ��� �����ϼ��� :");
		int you = sca.nextInt(); // 0, 1, 2 �� �ϳ��� �Է��ؾ� ��
		if(you == 0) {
			System.out.println("����� ����");
		}else if(you == 1) {
			System.out.println("����� ����");
		}else if(you == 2) {
			System.out.println("����� ��");
		}else {
			System.out.println("��ȿ���� �ʴ� ���Դϴ�");
		}
	}

}
