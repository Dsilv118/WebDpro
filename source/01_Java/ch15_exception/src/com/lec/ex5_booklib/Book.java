package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890��-01-11", "Java", "ȫ�浿")

public class Book implements ILendable {
	private String bookNo;    // å��ȣ 
	private String bookTitle; // å�̸�
	private String writer;    // ����
	private String borrower;  // ������
	private Date checkOutDate;
	private byte state;         // ���Ⱑ��(0), ������(1)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		if(state == STATE_BORROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + "������ �������Դϴ�");
			return;
		}
		// state�� 0(STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E����)");
		state = STATE_BORROWED; // "������" ���·� ��ȯ
		System.out.println(bookTitle + "������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ :" + borrower + "\t������ :" + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception{
		if(state==STATE_NORMAL) {
			throw new Exception(bookTitle + "������ �ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���");  // x
			// ���� ��ü ���� �߻��ؤ� throws
		}
		// checkoutdate�� ����������� ��¥ ���
		
		Date now = new Date(); // ����
		long nowMillis = now.getTime(); // 1970.1.1 ~ now���� �и�����
		long checkMillis = checkOutDate.getTime(); 
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24)); 
		// ��ü�� ��� -> ��ü�� �´��� ���ο� ����
		if(day>14) {
			System.out.printf("%d��ŭ ���. ��ü�� %d��ŭ ���ž��մϴ�. ������ y �ȳ����� n", day, day*1000);
			Scanner sca = new Scanner(System.in);
			String sTr = sca.next().trim();
			if(sTr.equalsIgnoreCase("n")) {
				return;
			}
		}
		borrower = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E����)");
		String msg = bookNo + "\t" + bookTitle + "(" + writer +"��) -";
		//msg = msg + "���Ⱑ��";
		msg += state == STATE_NORMAL ? "���Ⱑ�� " : "���� �� " + sdf.format(checkOutDate);
		return msg;
	}
	
	// getters
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public byte getState() {
		return state;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
