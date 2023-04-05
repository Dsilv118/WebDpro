package com.lec.ch05.quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String loc1 = "classpath:META-INF/quiz/dev.xml";
		String loc2 = "classpath:META-INF/quiz/run.xml";
		String config = null;
		Scanner sca = new Scanner(System.in);
		System.out.println("DEV 또는 RUN을 입력해주세요");
		String input = sca.next();
		if(input.equalsIgnoreCase("DEV")) {
			config = "dev";
		} else if(input.equalsIgnoreCase("RUN")) {
			config = "run";
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다");
			System.exit(0);
		}
		sca.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load(loc1, loc2);
		ctx.refresh();
		EnvInfo info = ctx.getBean("EnvInfo", EnvInfo.class);
		System.out.println("ipNum : " + info.getIpNum());
		System.out.println("portNum : " + info.getPortNum());
		System.out.println("userId : " + info.getUserId());
		System.out.println("pw : " + info.getPw());
	}
	
}
