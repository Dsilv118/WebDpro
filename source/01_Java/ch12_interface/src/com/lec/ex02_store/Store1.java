package com.lec.ex02_store;

// 1ȣ�� : �δ�� - 5,000��  ���뱹 - ���Ⱦ�

public class Store1 implements HeadQuarterStore {
	private String storeName;

	public Store1(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 �� �Ⱦ�");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 4500��");
		
	}
	@Override
	public void bibim() {
		System.out.println("����� : 6000��");
		
	}
	@Override
	public void gongibab() {
		System.out.println("����� 1000��");
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
}
