package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new Book("890ㅁ-01-11", "Java", "홍길동")

public class Book implements ILendable {
	private String bookNo;    // 책번호 
	private String bookTitle; // 책이름
	private String writer;    // 저자
	private String borrower;  // 대출인
	private Date checkOutDate;
	private byte state;         // 대출가능(0), 대출중(1)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		if(state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + "도서는 대출중입니다");
			return;
		}
		// state가 0(STATE_NORMAL)이라서 대출 진행
		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E요일)");
		state = STATE_BORROWED; // "대출중" 상태로 전환
		System.out.println(bookTitle + "도서가 대출 처리 되었습니다");
		System.out.println("대출인 :" + borrower + "\t대출일 :" + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception{
		if(state==STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 반납완료된 책입니다. 확인하세요");  // x
			// 예외 객체 강제 발생해ㅓ throws
		}
		// checkoutdate와 현재시점간의 날짜 계산
		
		Date now = new Date(); // 지금
		long nowMillis = now.getTime(); // 1970.1.1 ~ now까지 밀리세컨
		long checkMillis = checkOutDate.getTime(); 
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24)); 
		// 연체료 출력 -> 연체료 냈는지 여부에 따라
		if(day>14) {
			System.out.printf("%d만큼 경과. 연체료 %d만큼 내셔야합니다. 냈으면 y 안냈으면 n", day, day*1000);
			Scanner sca = new Scanner(System.in);
			String sTr = sca.next().trim();
			if(sTr.equalsIgnoreCase("n")) {
				return;
			}
		}
		borrower = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E요일)");
		String msg = bookNo + "\t" + bookTitle + "(" + writer +"著) -";
		//msg = msg + "대출가능";
		msg += state == STATE_NORMAL ? "대출가능 " : "대출 중 " + sdf.format(checkOutDate);
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
