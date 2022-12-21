package com.lec.ex1_runnable;

public class Ex01_TargetTestMain {
	public static void main(String[] args) {
		Target tar = new Target();
		//Runnable tar = new Target();
		// "★A"라는 이름의 쓰레드를 생성 - tar.run()을 동시에 수행할 쓰레드
		Thread t1 = new Thread(tar, "★A");
		// "~B"라는 이름의 쓰레드를 생성 = tar.run();을 동시에 수행할 쓰레드
		Thread t2 = new Thread(tar, "~B");
		t1.start();
		t2.start();
		System.out.println("main함수 쓰레드명 : " + Thread.currentThread().getName());
		System.out.println("main함수 끝");
	}
}
