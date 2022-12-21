package com.lec.ex4_product;

public class Product {
	private int serialNo; // 객체 고유의 번호
	public static int count=100; // static 변수 = 클래스 변수 = 공유 변수
	public Product() {
		serialNo = ++count;
	}
	public static void staticMethod() {
		System.out.println("static 메소드 test");
	}	
	public void infoPrint() {
		System.out.println("시리얼 번호 : " + serialNo + "\t공유변수 count : " + count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
