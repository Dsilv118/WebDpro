package com.lec.conditionQuiz;
// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. ��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�, ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �����ϼ��� :");
		int use = sca.nextInt();
		int com = (int)(Math.random()*3);
		if(use == 0) {
			System.out.println(com);
			if(com == 0) {
				System.out.println("���º�");
			}else if(com == 1) {
				System.out.println("�й�");
			}else {
				System.out.println("�¸�");
			}
		}
		if(use == 1) {
			System.out.println(com);
			if(com == 0) {
				System.out.println("�¸�");
			}else if(com == 1) {
				System.out.println("���º�");
			}else {
				System.out.println("�й�");
			}
		}
		if(use == 2) {
			System.out.println(com);
			if(com == 0) {
				System.out.println("�й�");
			}else if(use == 1) {
				System.out.println("�¸�");
			}else {
				System.out.println("���º�");
			}
		}
		if(use > 2) {
			System.out.println("���� ��ȣ�Դϴ�");
		}
		sca.close();
	}
}


