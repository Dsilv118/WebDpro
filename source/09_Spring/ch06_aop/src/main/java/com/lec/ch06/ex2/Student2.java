package com.lec.ch06.ex2;

import lombok.Data;

@Data
public class Student2 {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	public void getStudentInfo() { // 호출될 핵심 기능(joinPoint = 비즈니스 로직, 타겟 메소드)
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("학년 : " + gradeNum);
		System.out.println("반   : " + classNum);
	}
}
