package com.lec.conditionQuiz;
// ���� ��������� Ű����κ��� �Է¹޾� ������ ����ϴ� ���α׷��� �����ϼ���
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("������� �Է��� �ּ���");
		int mon = sca.nextInt();
		if(3 <= mon && mon < 6) {
			System.out.println("���Դϴ�");
		}else if(6 <= mon && mon < 9) {
			System.out.println("�����Դϴ�");
		}else if(9 <= mon && mon < 11) {
			System.out.println("�����Դϴ�");
		}else if(13 <= mon) {
			System.out.println("���� �����Դϴ�");
	    }else {
	    	System.out.println("�ܿ��Դϴ�");
	    }
	}

}
