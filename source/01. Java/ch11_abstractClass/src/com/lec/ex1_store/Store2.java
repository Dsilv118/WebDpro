package com.lec.ex1_store;

// 2ȣ�� : �δ�� - 5,000��  ����� - 5,000�� ����� ����

public class Store2 extends HeadQuarterStore {

	public Store2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� : 5,000��");
	}
	@Override
	public void gongibab() {
		System.out.println("���뱹 : ����");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� : ����");
		
	}
	@Override
	public void sunde() {
		System.out.println("����� : ����");
		
	}
}
