package com.lec.ex2_parking;

import com.lec.constant.Constant;

// ������ : �ڵ��� ��ȣ, ���� �ð�, ���� ��� 
// �޼ҵ� : out(int outTime)
public class Parking {
	private String num;
	private int    inTime;
	private int    money;
//	private final int    HOURLYPARKINGRATE = 2000; // ��� (final ����)
	public Parking() {}
	public Parking(String num, int inTime) { // ����
		this.num = num;
		this.inTime = inTime;
		System.out.printf("\"%s\"�� ������� \n�����ð� :%d�� \n", num, inTime);
	}
	public void out(int outTime) { // ����
		money = (outTime-inTime)* Constant.HOURLYPARKINGRATE;
		System.out.printf("\"%s\"�� �ȳ��� ������ \n�����ð� : %d�� \n�����ð� : %d�� \n������� : %d�� \n",num, inTime, outTime, money);
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
