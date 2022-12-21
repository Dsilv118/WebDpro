package com.lec.ex02_store;

// 1È£Á¡ : ºÎ´ëÂî°³ - 5,000¿ø  ¼ø´ë±¹ - ¾ÈÆÈ¾Æ

public class Store1 implements HeadQuarterStore {
	private String storeName;

	public Store1(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 5,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ ¾È ÆÈ¾Æ");
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 4500¿ø");
		
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 6000¿ø");
		
	}
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä 1000¿ø");
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
}
