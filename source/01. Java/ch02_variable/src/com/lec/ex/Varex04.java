package com.lec.ex;
// 실수는 double을 쓰자. 연산시 유의점
public class Varex04 {
	public static void main(String[] args) {
		// 변수 선언은 위치 제약이 없다. 다만 위에 선언할 것을 추천
		char c = '씨'; // 2byte
		int i = 20; // 4byte (int 4바이트 double 8바이트 꼭 기억하기)
		long l = 22000000000L; // 8byte
		System.out.println("l = " + l);
		boolean b = true; // 1byte
		System.out.println("b = " + b);
		float f = 3.14159265359F; // 4byte
		double d = 3.14159265359; // 8byte
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if(f == d) {
			System.out.println("f와 d값은 같다");
		}else {
			System.out.println("f와 d값은 다르다");
		}
		f = 10.1F;
		d = 10.1;
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if(f == d) {
			System.out.println("f와 d값은 같다");
		}else {
			System.out.println("f와 d값은 다르다");
		}
		// 정수(4byte)랑 실수(8byte)랑 연산 i+d : i+d(8byte)
		System.out.println("i + d = " + (i+d));
		// 정수(4byte)랑 정수(4byte)랑 연산한 결과 : 4byte
		System.out.println("i / 7 = " + (i/7));
	}
}
