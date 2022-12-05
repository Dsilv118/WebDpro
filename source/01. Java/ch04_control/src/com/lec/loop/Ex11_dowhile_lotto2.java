package com.lec.loop;

import java.util.Scanner;

// 컴퓨터가 발생 로또 난수를 맞추기
public class Ex11_dowhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // 컴퓨터 로또번호와 사용자로부터 입력받은 수
		int min=1, max=45;
		Scanner sca = new Scanner(System.in);
		lotto = (int)(Math.random()*45+1); // 로또번호
		do {
			System.out.printf("로또 번호 한개를 맞춰 보세요(%d~%d) :", min, max);
			su = sca.nextInt();
			if(su < min || su > max) {
				System.out.println("범위를 벗어났습니다");
			}else if(su>lotto) { // 최대값 최소값 구분 잘하기
				max = su -1 ;
				//System.out.println(su+"보다 작은수를 도전하세요");
			}else if(su<lotto) {
				min = su +1 ;
				//System.out.println(su + "보다 큰수를 도전하세요");
			}
		}while(su!=lotto);
		System.out.println("축하축하 맞추셨습니다");
	}
}
