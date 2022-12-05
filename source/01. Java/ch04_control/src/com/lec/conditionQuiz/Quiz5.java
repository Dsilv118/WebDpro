package com.lec.conditionQuiz;
// 현재 몇월인지를 키보드로부터 입력받아 계절을 출력하는 프로그램을 구현하세요
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("몇월인지 입력해 주세요");
		int mon = sca.nextInt();
		if(3 <= mon && mon < 6) {
			System.out.println("봄입니다");
		}else if(6 <= mon && mon < 9) {
			System.out.println("여름입니다");
		}else if(9 <= mon && mon < 11) {
			System.out.println("가을입니다");
		}else if(13 <= mon) {
			System.out.println("없는 계절입니다");
	    }else {
	    	System.out.println("겨울입니다");
	    }
	}

}
