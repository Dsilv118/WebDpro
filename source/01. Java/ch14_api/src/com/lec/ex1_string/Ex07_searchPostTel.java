package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ ���ڸ��� �Է¹޾� �˻��� ��ȭ��ȣ(�ߺ��� ���ڸ� ����)�� ���

public class Ex07_searchPostTel {
	public static void main(String[] args) {
		String[] tels = {"010-4444-4444", "02-123-1234", "010-5512-9999", "010-4412-9999"};
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOK = false; // �˻��� ����� ������ true
			System.out.println("�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ�?(����� x)"); // 8888
			String searchTel = sc.next();
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(int i=0 ; i<tels.length ; i++) {
	//			int idx = tels[i].lastIndexOf("-"); // 8,6...
	//			String postTel = tels[i].substring(idx+1);
	//			System.out.println(i+"��° ���ڸ� : " + postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-")+1);
				if(postTel.equals(searchTel)) {
					System.out.println("�˻��Ͻ� ��ȭ��ȣ��" + tels[i]);
					searchOK = true; // ��ȭ��ȣ ��¿���
				}
			}
			if(!searchOK) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ ���ڸ��� �����ϴ�");
			}
		}	
	}
}











