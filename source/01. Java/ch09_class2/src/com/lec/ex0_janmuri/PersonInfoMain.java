package com.lec.ex0_janmuri;
// PersonInfoMain.java => PersonInfoMain Ŭ������ public���� ����Ǿ�� ��.
//                          �ڹ����Ͽ��� public Ŭ���� �Ѱ��� ����.  
class PersonInfo{
	private String name;
	private int age;
	private int gender;
	public PersonInfo(String name, int age, int genderl) {
		this.name = name;
		this.age = age;
		this.gender = genderl;
	}
	public void print() {
		System.out.println("�̸� : " + name +", ���� :" + age + ", ���� : " + gender);
	}
}
public class PersonInfoMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("ȫ", 25, 'f'),
				               new PersonInfo("��", 24, 'm')
		};
		for(PersonInfo p : person) {
			p.print();
		}
	}
}
