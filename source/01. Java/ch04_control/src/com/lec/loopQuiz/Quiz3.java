package com.lec.loopQuiz;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �����ܼ��� �Է¹޾� �ش� �������� ����� ����
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("���ϴ� ������ ���� �Է��ϼ���");
		int fnt = sca.nextInt();
		int tot = 1 ;
		int i=1;
		for(int i=1 ; i<10 ; i++) {
			tot = fnt * i ;
		}
		System.out.printf("%d x %d = %d", fnt, i, tot);
	}

}
