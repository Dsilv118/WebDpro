package com.lec.ex1_runnable;

public class Ex01_TargetTestMain {
	public static void main(String[] args) {
		Target tar = new Target();
		//Runnable tar = new Target();
		// "��A"��� �̸��� �����带 ���� - tar.run()�� ���ÿ� ������ ������
		Thread t1 = new Thread(tar, "��A");
		// "~B"��� �̸��� �����带 ���� = tar.run();�� ���ÿ� ������ ������
		Thread t2 = new Thread(tar, "~B");
		t1.start();
		t2.start();
		System.out.println("main�Լ� ������� : " + Thread.currentThread().getName());
		System.out.println("main�Լ� ��");
	}
}
