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
		for(int i1=1 ; i1<10 ; i1++) {
			tot = fnt * i1 ;
		}
		System.out.printf("%d x %d = %d", fnt, i, tot);
		sca.close();
	}

}
