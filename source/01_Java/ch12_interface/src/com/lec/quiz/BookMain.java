package com.lec.quiz;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890ㅁ-01-11", "Java", "홍길동"),
						new BookLib("890ㅁ-01-12", "Oracle", "오길동"),
						new BookLib("890ㅁ-02-01", "mysql", "마길동"),
						new BookLib("890ㅁ-01-11", "jdbc", "제이디"),
						new BookLib("890ㅁ-01-01", "html", "이에이")};
		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호 (1:대출/2:반납/3:책 list/0:종료)
		int idx; // 대출하거나 반납할 때, 조회된 책의 index
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책이름, 대출인, 대출일
		do {
			System.out.print("1:대출 / 2:반납 / 3:책 list / 0:종료");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // 대출 : 1.책 이름 입력 2.책 조회 3.책 상태 확인 4.대출인 입력 5.대출일 입력 6.대출 메소드 호출
				// 1. 책 이름 입력
				System.out.print("대출하고자 하는 책이름은?");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음
				// 2. 책 조회
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("현재 보유하지 않는 도서입니다");
				}else { // books[idx] 도서를 대출
					// 3. 책 상태 확인 
					if(books[idx].getState() == BookLib.STATE_BORROWED) { 
						System.out.println("현재 대출 중인 도서입니다");
					}else {
						// 4. 대출인 입력
						System.out.print("대출인은 ?");
						borrower = scanner.next();
						// 5. 대출일 입력 
						System.out.print("대출일 ?");
						checkOutDate = scanner.next(); // 2022-12-01(O), 2002 12 01(X)
						// 6. 대출 메소드 호출
						books[idx].checkOut(borrower, checkOutDate);
					}	
				}

				break;
			case 2: // 반납 : 1.책이름 입력 2.책조회 3.반납메소드 호출
				// 1. 책 이름 입력
				System.out.print("반납하고자 하는 책이름은?");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음
				// 2. 책 조회
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else { // 반납 메소드 호출
					books[idx].checkIn();
				}
				break;
			case 3: // 책 리스트 출력 : for문을 이용하여 printState()메소드 호출     
				for(BookLib bookLib : books) {
					bookLib.printState();
				}
			}
		}while(fn!=0);
		System.out.println("종료");
		scanner.close();
	}
}
