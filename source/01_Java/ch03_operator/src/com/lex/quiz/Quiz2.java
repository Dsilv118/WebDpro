package com.lex.quiz;

import java.util.Scanner;

// �Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		int a = sca.nextInt();
		if (a%2 == 0){ 
			System.out.println("¦���Դϴ�");
        }else{
        	System.out.println("Ȧ���Դϴ�");
		}	
		sca.close();
	}
}
