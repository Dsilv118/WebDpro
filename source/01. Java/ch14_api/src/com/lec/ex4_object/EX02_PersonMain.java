package com.lec.ex4_object;

public class EX02_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9802212922128L);
		Person p2 = new Person(9802212922128L);
		Person p3 = null;
		Person p4 = new Person();
		if(p1.equals(p2)) {
			System.out.println("p1�� p2�� ����");
		} else {
			System.out.println("p1�� p2�� �ٸ���");
		}
	}
}