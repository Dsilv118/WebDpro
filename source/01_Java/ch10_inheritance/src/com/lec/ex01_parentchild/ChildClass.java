package com.lec.ex01_parentchild;
// pStr, getPapaName(), getMamiName();
public class ChildClass extends ParentClass{
	String cStr = "자식클래스";
	public ChildClass() {
		System.out.println("자식 생성자");
	}
}
