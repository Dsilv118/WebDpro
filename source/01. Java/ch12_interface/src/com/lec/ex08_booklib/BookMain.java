package com.lec.ex08_booklib;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Book[] books = {new Book("890��-01-11", "Java", "ȫ�浿"),
						new Book("890��-01-12", "Oracle", "���浿"),
						new Book("890��-02-01", "mysql", "���浿"),
						new Book("890��-01-11", "jdbc", "���̵�"),
						new Book("890��-01-01", "html", "�̿���")};
		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1:����/2:�ݳ�/3:å list/0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å�̸�, ������, ������
		do {
			System.out.print("1:���� / 2:�ݳ� / 3:å list / 0:����");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // ���� : 1.å �̸� �Է� 2.å ��ȸ 3.å ���� Ȯ�� 4.������ �Է� 5.������ �Է� 6.���� �޼ҵ� ȣ��
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
						// 5. ������ �Է� 
						System.out.print("������ ?");
						checkOutDate = scanner.next(); // 2022-12-01(O), 2002 12 01(X)
						// 6. ���� �޼ҵ� ȣ��
						books[idx].checkOut(borrower, checkOutDate);
					}	
				}

				break;
			case 2: // �ݳ� : 1.å�̸� �Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
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
					books[idx].checkIn();
				}
				break;
			case 3: // å ����Ʈ ��� : for���� �̿��Ͽ� printState()�޼ҵ� ȣ��     
				for(Book book : books) {
					book.printState();
				}
			}
		}while(fn!=0);
		System.out.println("����");
	}
}