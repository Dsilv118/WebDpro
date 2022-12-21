package com.lec.Quiz;
// 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄 때, 몇개씩 주어야 하나?
public class Quiz3 {
	public static void main(String[] args) {
		int money = 2680 ;
		int[] coin = {500, 100, 50, 10} ;
		for(int i=0 ; i<coin.length ; i++) {
			System.out.println(coin[i] +"짜리 " + money/coin[i]);
			money = money%coin[i];
		}
	}
}
