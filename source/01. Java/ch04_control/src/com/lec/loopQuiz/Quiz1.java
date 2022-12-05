package com.lec.loopQuiz;
// 1~10까지의 곱의 결과를 출력해 보자
public class Quiz1 {
	public static void main(String[] args) {
		int result = 1;
		for(int i=1 ; i<=10 ; i++) {
			result *= i; 		
		}
		System.out.println("1~10까지의 곱은 " + result);
	}
}