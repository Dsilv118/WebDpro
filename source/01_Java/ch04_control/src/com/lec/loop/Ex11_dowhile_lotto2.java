package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ͱ� �߻� �ζ� ������ ���߱�
public class Ex11_dowhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // ��ǻ�� �ζǹ�ȣ�� ����ڷκ��� �Է¹��� ��
		int min=1, max=45;
		Scanner sca = new Scanner(System.in);
		lotto = (int)(Math.random()*45+1); // �ζǹ�ȣ
		do {
			System.out.printf("�ζ� ��ȣ �Ѱ��� ���� ������(%d~%d) :", min, max);
			su = sca.nextInt();
			if(su < min || su > max) {
				System.out.println("������ ������ϴ�");
			}else if(su>lotto) { // �ִ밪 �ּҰ� ���� ���ϱ�
				max = su -1 ;
				//System.out.println(su+"���� �������� �����ϼ���");
			}else if(su<lotto) {
				min = su +1 ;
				//System.out.println(su + "���� ū���� �����ϼ���");
			}
		}while(su!=lotto);
		System.out.println("�������� ���߼̽��ϴ�");
	}
}
