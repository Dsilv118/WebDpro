package com.lec.ex09_customer;
// name, num, infoString
public class Staff extends Person {
	private String hiredate; // �Ի���("2000-12-12") �����ֺ��� Date��
	private String department; // �μ�
	// Staff s = new Staff("ȫ���", "010-8888-8888", "2022-12-01", "�����")
	public Staff(String name, String num, String hiredate, String department) {
		super(name, num);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "   [�μ�]" + department + "    [�Ի���]" + hiredate;
	}
}