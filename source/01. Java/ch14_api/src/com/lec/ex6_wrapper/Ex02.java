package com.lec.ex6_wrapper;

// java.com.lec.ex6_wrapper.Ex02 10 20 30 1 실행
// 결과 : 들어온 값의 갯수 -> 4개
//       들어온 값의 합 : 61

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("들어온 값의 객수 : " + args.length);
		int total = 0; // 누적 변수
		for(int i=0 ; i<args.length ; i++) {
			total += Integer.parseInt(args[i]);
			System.out.println(args[i]);
		}
		System.out.println("들어온 값의 합 : " + total);
	}
}
