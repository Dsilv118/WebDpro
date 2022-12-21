package com.lex.quiz;

import java.util.Scanner;

//국어, 영어, 수학 점수를 사용자에게 입력받아, 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		int kor = sca.nextInt();
		System.out.println("영어 점수를 입력하세요");
		int eng = sca.nextInt();
		System.out.println("수학 점수를 입력하세요");
		int math = sca.nextInt();
		int all = (kor + eng + math);
		double avg = (all/3.0);
		System.out.println("총점은" + all);
		System.out.printf("평균은 %.2f\n", avg);
		sca.close();
	}
}
