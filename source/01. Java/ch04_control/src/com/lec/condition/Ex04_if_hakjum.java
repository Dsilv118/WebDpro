package com.lec.condition;

import java.util.Scanner;

// 점수를 입력받아 학점 출력 
public class Ex04_if_hakjum {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("점수는?");
		int score = sca.nextInt();
		// 90 <= score < 100
		if(90 <= score && score < 100) {
			System.out.println("A학점");
		}else if(80 <= score && score < 90) {
			System.out.println("B학점");
		}else if(70 <= score && score < 80) {
			System.out.println("c학점");
		}else if(60 <= score && score < 70) {
			System.out.println("D학점");
		}else {
			System.out.println("유효하지 않는 점수입니다");
		}
	}

}
