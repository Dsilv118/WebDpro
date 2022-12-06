package com.lec.ex2_parking;

import com.lec.constant.Constant;

// 데이터 : 자동차 번호, 입차 시간, 주차 요금 
// 메소드 : out(int outTime)
public class Parking {
	private String num;
	private int    inTime;
	private int    money;
//	private final int    HOURLYPARKINGRATE = 2000; // 상수 (final 변수)
	public Parking() {}
	public Parking(String num, int inTime) { // 입차
		this.num = num;
		this.inTime = inTime;
		System.out.printf("\"%s\"님 어서오세요 \n입차시간 :%d시 \n", num, inTime);
	}
	public void out(int outTime) { // 출차
		money = (outTime-inTime)* Constant.HOURLYPARKINGRATE;
		System.out.printf("\"%s\"님 안녕히 가세요 \n입차시간 : %d시 \n출차시간 : %d시 \n주차요금 : %d원 \n",num, inTime, outTime, money);
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
