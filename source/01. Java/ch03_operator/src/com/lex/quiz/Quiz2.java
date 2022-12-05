package com.lex.quiz;

import java.util.Scanner;

// 입력한 수가 짝수인지 홀수인지 출력
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int a = sca.nextInt();
		if (a%2 == 0){ 
			System.out.println("짝수입니다");
        }else{
        	System.out.println("홀수입니다");
		}	
		sca.close();
	}
}
