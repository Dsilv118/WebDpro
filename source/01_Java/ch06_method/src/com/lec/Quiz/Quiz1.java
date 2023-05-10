package com.lec.Quiz;

import java.util.Scanner;

// 사용자로부터 원하는 단수(2~9) 구구단을 출력하는 프로그램을 구현하시오
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in) ;
		int num = 0 ;
		do {
			System.out.print("원하는 구구단 수를 입력하세요") ;
			num = sca.nextInt() ;
		} while(num<=1 || num>=10) ;
		use(num) ;
	}
	public static void use(int a) {
		for(int b=1 ; b<10 ; b++) {
			int tot = a*b ;
				System.out.printf("%d x %d = %d\t", a, b, tot);
		}
	}	
}
