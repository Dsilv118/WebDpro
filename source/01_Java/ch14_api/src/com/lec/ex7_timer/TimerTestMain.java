package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer time = new Timer(true); // ���α׷� ����� timer�� �޸� �������� X
		TimerTask task1 = new TimerTaskEx1(); // 2�� �� �ѹ�
		TimerTask task2 = new TimerTaskEx2();
		time.schedule(task1, 2000);      // 2�� �� �ѹ� task1.run() ����
		time.schedule(task2, 1000, 500); // 1���ĺ��� 0.5�ʸ��� task2.run() ����
		Thread.sleep(11000);
		System.out.println("��");
	}
}