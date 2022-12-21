package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s0bj = new S(); // 생성자 함수 1개 실행 
		// A a0bj = new A();
		S a0bj = new A(); // 생성자 함수 2개 실행(부모단 + 자식단)
		// B b0bj = new B();
		S b0bj = new B(); 
		S c0bj = new C();
//		S[] arr = {new S(), new A(), new B(), new C()};
		S[] arr = {s0bj, a0bj, b0bj, c0bj};
		for(S a : arr) {
			System.out.println("s =" + a.s);
		}
	}
}
