package com.lec.loop;

import java.util.Scanner;

// 짝수를 입력받아 출력
public class Ex10_dowhile {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int num;
		do {
			System.out.println("짝수를 입력하세요 :");
			num = sca.nextInt();
		}while(num%2!=0);
		System.out.println("입력한 짝수는" + num);
		sca.close();
	}
	

}
