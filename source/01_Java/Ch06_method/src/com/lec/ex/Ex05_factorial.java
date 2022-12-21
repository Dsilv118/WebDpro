package com.lec.ex;

import java.util.Scanner;

// 5! = 5*4*3*2*1
// 1! = 1 (factorial ����� ����� �Է��ϴ� ������ �Ѵ�)
public class Ex05_factorial {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in) ;
		System.out.print("�� !�� ����ұ��? ") ;
		int num = sca.nextInt() ;
		long result = factorial(num) ;
		System.out.println(num + "! = " + result) ;
	}
	private static long factorial(int s) {
		long result = 1 ; // �������� ������ ����
		for(int i=s ; i>=1 ; i--) {
			result *= i ;
		}
		return result ;
		
	}
}
