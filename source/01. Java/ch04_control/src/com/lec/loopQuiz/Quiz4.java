package com.lec.loopQuiz;
// 다음과 같은 출력형식의 구구단을 출력하는 프로그램을 구현해 보자
public class Quiz4 {
	public static void main(String[] args) {
		for(int i=1 ; i<10 ; i++) {
			for(int j=2 ; j<10 ; j++) {
				System.out.printf("%d * %d = %d\t",j, i, j*i);
			}
			System.out.println();
		}
	}
}
