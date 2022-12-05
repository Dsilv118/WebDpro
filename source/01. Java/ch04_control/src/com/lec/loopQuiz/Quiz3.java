package com.lec.loopQuiz;

import java.util.Scanner;

// 사용자로부터 원하는 구구단수를 입력받아 해당 구구단을 출력해 보자
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("원하는 구구단 수를 입력하세요");
		int fnt = sca.nextInt();
		int tot = 1 ;
		int i=1;
		for(int i=1 ; i<10 ; i++) {
			tot = fnt * i ;
		}
		System.out.printf("%d x %d = %d", fnt, i, tot);
	}

}
