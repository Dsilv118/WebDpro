package com.lex.quiz;

import java.util.Scanner;

// 나이를 입력받아 입력받은 나이가 65세 이상일 때, “경로우대” 출력, 아니면 “일반”출력
public class Quiz4 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("나이를 입력하세요");
		int age = sca.nextInt();
		if (age > 65) {
			System.out.println("경로우대");
		}else if(age>=0){
			System.out.println("일반");
		}else {
			System.out.println("떼끼");
		}
		sca.close();
	}
}
