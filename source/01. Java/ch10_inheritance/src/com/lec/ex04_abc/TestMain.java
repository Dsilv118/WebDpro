package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s0bj = new S(); // ������ �Լ� 1�� ���� 
		// A a0bj = new A();
		S a0bj = new A(); // ������ �Լ� 2�� ����(�θ�� + �ڽĴ�)
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
