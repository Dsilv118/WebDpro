package com.lec.Quiz;

import java.util.Scanner;

// ����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in) ;
		int num = 0 ;
		do {
			System.out.print("���ϴ� ������ ���� �Է��ϼ���") ;
			num = sca.nextInt() ;
		} while(num<=1 || num>=10) ;
		use(num) ;
	}
	public static void use(int a) {
		for(int b=1 ; b<10 ; b++) {
			int tot = a*b ;
				System.out.printf("%d x %d = %d\t", a, b, tot);
		}
	}	
}
