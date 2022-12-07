package com.lec.ex09_customer;

import cons.Constant;

public class Customer extends Person {
	private String address;
	private int    sum; // 구매금액 누적
	private int    point; // 포인트(구매 시 1%)
	private String date; // String을 다음주부터는 Date형
	private boolean vip;    
	// Customer c = new Customer("홍길동", "010-9999-9999", "서울", "12-12"
	
	public Customer(String name, String num, String address, String date) {
		// TODO Auto-generated constructor stub
		super(name, num);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name + "님 가입 감사합니다. 포인트 1000점을 드렸습니다");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price; // 구매금액에 누적
		// int tempPoint = (int)(price * 0.05); 
		int tempPoint = (int)(price * Constant.RATE);
		point += tempPoint; // 포인트 누적
		System.out.println(getName() + "님 감사합니다. 금번 포인트 :" + tempPoint);
		System.out.println("누적 포인트 : " + point);
		System.out.println("구매 금액 : " + price);
		if(vip==false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName() + "님 VIP 고객으로 업그레이드 되셨습니다. 자주 뵙겠습니다");
		} // if 
	} // buy
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "   [주소]" + address + "   [포인트]" + point + "   [누적구매금액]" + sum
				                    + "   [vip여부]" +   vip;
	}
}
