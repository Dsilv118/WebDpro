package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {
	@Override
	public void run() {
		System.out.println("~ ~ ~작업 2 : 1초 후 0.5초마다 실행될 예정인 TimerTask");

	}

}
