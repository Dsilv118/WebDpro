package com.lec.condition;

import java.util.Scanner;

// ������ �Է¹޾� ���� ��� 
public class Ex04_if_hakjum {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("������?");
		int score = sca.nextInt();
		// 90 <= score < 100
		if(90 <= score && score < 100) {
			System.out.println("A����");
		}else if(80 <= score && score < 90) {
			System.out.println("B����");
		}else if(70 <= score && score < 80) {
			System.out.println("c����");
		}else if(60 <= score && score < 70) {
			System.out.println("D����");
		}else {
			System.out.println("��ȿ���� �ʴ� �����Դϴ�");
		}
	}

}
