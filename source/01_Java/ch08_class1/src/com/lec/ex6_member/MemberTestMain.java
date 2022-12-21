package com.lec.ex6_member;

public class MemberTestMain {
	public static void main(String[] args) {
		Member acco = new Member("aaa", "xxx", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", 'm');
		System.out.println(acco.infoString());
	}
}
