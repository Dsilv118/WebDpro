package com.lec.conditionQuiz;
// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요 :");
		int use = sca.nextInt();
		int com = (int)(Math.random()*3);
		if(use == 0) {
			System.out.println(com);
			if(com == 0) {
				System.out.println("무승부");
			}else if(com == 1) {
				System.out.println("패배");
			}else {
				System.out.println("승리");
			}
		}
		if(use == 1) {
			System.out.println(com);
			if(com == 0) {
				System.out.println("승리");
			}else if(com == 1) {
				System.out.println("무승부");
			}else {
				System.out.println("패배");
			}
		}
		if(use == 2) {
			System.out.println(com);
			if(com == 0) {
				System.out.println("패배");
			}else if(use == 1) {
				System.out.println("승리");
			}else {
				System.out.println("무승부");
			}
		}
		if(use > 2) {
			System.out.println("없는 번호입니다");
		}
		sca.close();
	}
}


