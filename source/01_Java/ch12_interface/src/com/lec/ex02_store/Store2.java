package com.lec.ex02_store;

// 2È£Á¡ : ºÎ´ëÂî°³ - 5,000¿ø  ºñºö¹ä - 5,000¿ø °ø±â¹ä ¹«·á

public class Store2 implements HeadQuarterStore {
	private String storeName;
	
	public Store2(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 5,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 5,000¿ø");
	}
	@Override
	public void gongibab() {
		System.out.println("¼ø´ë±¹ : ¹«·á");
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : ¹«·á");
		
	}
	@Override
	public void sunde() {
		System.out.println("°ø±â¹ä : ¹«·á");
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
}
