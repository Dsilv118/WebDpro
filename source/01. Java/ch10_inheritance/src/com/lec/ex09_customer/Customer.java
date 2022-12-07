package com.lec.ex09_customer;

import cons.Constant;

public class Customer extends Person {
	private String address;
	private int    sum; // ���űݾ� ����
	private int    point; // ����Ʈ(���� �� 1%)
	private String date; // String�� �����ֺ��ʹ� Date��
	private boolean vip;    
	// Customer c = new Customer("ȫ�浿", "010-9999-9999", "����", "12-12"
	
	public Customer(String name, String num, String address, String date) {
		// TODO Auto-generated constructor stub
		super(name, num);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name + "�� ���� �����մϴ�. ����Ʈ 1000���� ��Ƚ��ϴ�");
	}
	public void buy(int price) { // c.buy(2000);
		sum += price; // ���űݾ׿� ����
		// int tempPoint = (int)(price * 0.05); 
		int tempPoint = (int)(price * Constant.RATE);
		point += tempPoint; // ����Ʈ ����
		System.out.println(getName() + "�� �����մϴ�. �ݹ� ����Ʈ :" + tempPoint);
		System.out.println("���� ����Ʈ : " + point);
		System.out.println("���� �ݾ� : " + price);
		if(vip==false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println(getName() + "�� VIP ������ ���׷��̵� �Ǽ̽��ϴ�. ���� �˰ڽ��ϴ�");
		} // if 
	} // buy
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "   [�ּ�]" + address + "   [����Ʈ]" + point + "   [�������űݾ�]" + sum
				                    + "   [vip����]" +   vip;
	}
}
