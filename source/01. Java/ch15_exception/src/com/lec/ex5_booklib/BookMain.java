package com.lec.ex5_booklib;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Book[] books = {new Book("428��-09-04", "Java", "ȫ�浿"),
						new Book("891��-05-12", "Oracle", "���浿"),
						new Book("769��-02-30", "mysql", "���浿"),
						new Book("622��-06-28", "jdbc", "���̵�"),
						new Book("190��-11-01", "html", "�̿���")};
		Scanner scanner = new Scanner(System.in);
		String fn; // ��ɹ�ȣ (1:����/2:�ݳ�/3:å list/0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å�̸�, ������, ������
		do {
			System.out.print("1:���� / 2:�ݳ� / 3:å list / �׿�:����");
			fn = scanner.next();
			switch(fn) {
			case "1": // ���� : 1.å �̸� �Է� 2.å ��ȸ 3.å ���� Ȯ�� 4.������ �Է� 5.������ �Է� 6.���� �޼ҵ� ȣ��
				// 1. å �̸� �Է�
				System.out.print("�����ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2. å ��ȸ
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�");
				}else { // books[idx] ������ ����
					// 3. å ���� Ȯ�� 
					if(books[idx].getState() == Book.STATE_BORROWED) { 
						System.out.println("���� ���� ���� �����Դϴ�");
					}else {
						// 4. ������ �Է�
						System.out.print("�������� ?");
						borrower = scanner.next();
						// 6. ���� �޼ҵ� ȣ��
						books[idx].checkOut(borrower);
					}	
				}

				break;
			case "2": // �ݳ� : 1.å�̸� �Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
				// 1. å �̸� �Է�
				System.out.print("�ݳ��ϰ��� �ϴ� å�̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2. å ��ȸ
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				}else { // �ݳ� �޼ҵ� ȣ��
					try {
						books[idx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "3": // å ����Ʈ ��� : for���� �̿��Ͽ� printState()�޼ҵ� ȣ��     
				for(Book book : books) {
					System.out.println(book);
				}
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("����"); 
	}
}
