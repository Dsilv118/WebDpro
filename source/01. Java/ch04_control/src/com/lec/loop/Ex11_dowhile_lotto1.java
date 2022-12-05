package com.lec.loop;

import java.util.Scanner;

// 컴퓨터가 발생 로또 난수를 맞추기
public class Ex11_dowhile_lotto1 {
	public static void main(String[] args) {
		int lotto, su; // 컴퓨터 로또번호와 사용자로부터 입력받은 수
		Scanner sca = new Scanner(System.in);
		// 0 <= Math.random() < 1 : 실수
		// 0 <= Math.random()*45 < 45 : 실수
		// 1 <= Math.random()*45+1 < 46 : 실수
		// 1 <= (int)(Math.random()*45+1) < 46 : 괄호로 꼭 묶어놔야됨
		lotto = (int)(Math.random()*45+1); // 로또번호
		do {
			System.out.println("로또 번호 한개를 맞춰 보세요(1~45) :");
			su = sca.nextInt();
			if(su>lotto) {
				System.out.println(su+"보다 작은수를 도전하세요");
			}else if(su<lotto) {
				System.out.println(su + "보다 큰수를 도전하세요");
			}
		}while(su!=lotto);
		System.out.println("축하축하 맞추셨습니다");
	}
}
