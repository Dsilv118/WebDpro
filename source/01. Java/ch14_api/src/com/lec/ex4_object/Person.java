package com.lec.ex4_object;

// 주민번호 입력 : 9801181029112

public class Person {
	private long juminNo;

	public Person() {}
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민 번호는 " + juminNo;
	}
    @Override
    public boolean equals(Object obj) {
    	// this의 주민번호와 obj의 주민번호가 같은지 다른지 여부 
    	return (this == obj); // p1.equals(p2) : p1이 this. p2가 obj
    }
}
