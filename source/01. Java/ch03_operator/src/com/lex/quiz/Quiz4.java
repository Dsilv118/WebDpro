package com.lex.quiz;

import java.util.Scanner;

// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
public class Quiz4 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���");
		int age = sca.nextInt();
		if (age > 65) {
			System.out.println("��ο��");
		}else if(age>=0){
			System.out.println("�Ϲ�");
		}else {
			System.out.println("����");
		}
		sca.close();
	}
}
