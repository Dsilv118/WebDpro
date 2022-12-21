package com.lec.ex4_object;

// �ֹι�ȣ �Է� : 9801181029112

public class Person {
	private long juminNo;

	public Person() {}
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "�ֹ� ��ȣ�� " + juminNo;
	}
    @Override
    public boolean equals(Object obj) {
    	// p1.equals(p2) : p1�� this. p2�� obj
    	// this�� �ֹι�ȣ�� obj�� �ֹι�ȣ�� ������ �ٸ��� ���� return
    	if(obj!=null && obj instanceof Person) {
    		return juminNo == ((Person)obj).juminNo;
    	} else {
    		return false;
    	}
    }
}
