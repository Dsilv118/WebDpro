package com.lec.ex5_printwriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex {
	public static void main(String[] args) {
		OutputStream         os = null; // �⺻��Ʈ��
		Writer            write = null; // �⺻��Ʈ��
		PrintWriter printWriter = null;
		try {
			// 1. PrintWriter : OutputStream�� ������Ʈ��
//			os = new FileOutputStream("txtFile/outTest.txt");
//			printWriter = new PrintWriter(os); 
			// 2. PrintWriter : Writer�� ������Ʈ�� 
//			write = new FileWriter("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(write);
			// 3. PrintWriter�� �⺻��Ʈ��ó�� ���
			printWriter = new PrintWriter("txtFile/outTest.txt"); // append �Ұ�
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			System.out.print("print�� �ڵ������� �ȵſ�. �׷��� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵſ�. �׷��� �����߰�\n");
			System.out.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 95, 94, 94.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 95, 95, 94.5);
			System.out.printf("%s %3d %3d %5.1f\n", "�ű浿", 100, 99, 99.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "�ű浿", 100, 99, 99.5);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(printWriter!=null) 
					printWriter.close();
				if(write!=null) 
					write.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
