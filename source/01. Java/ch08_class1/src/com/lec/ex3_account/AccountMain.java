package com.lec.ex3_account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("110-1", "È«±æµ¿", 1000);
	//	hong.infoprint();
		System.out.println(hong.infoString());
		Account hong1 = new Account("110-2", "È«±æ¼ø");
		System.out.println(hong1.infoString());
		Account hong2 = new Account(); 
		System.out.println(hong2.infoString());
		hong.withdraw(500);
		hong.deposite(10000);
		hong1.deposite(22000000000L);
		hong1.withdraw(24000000000L);
	}
}
