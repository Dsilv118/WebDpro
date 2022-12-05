package com.lec.ex;

import java.util.Scanner;

// 5! = 5*4*3*2*1
// 1! = 1 (factorial 계산은 양수만 입력하는 것으로 한다)
public class Ex05_factorial {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in) ;
		System.out.print("몇 !을 계산할까요? ") ;
		int num = sca.nextInt() ;
		long result = factorial(num) ;
		System.out.println(num + "! = " + result) ;
	}
	private static long factorial(int s) {
		long result = 1 ; // 누적곱을 저장할 변수
		for(int i=s ; i>=1 ; i--) {
			result *= i ;
		}
		return result ;
		
	}
}
