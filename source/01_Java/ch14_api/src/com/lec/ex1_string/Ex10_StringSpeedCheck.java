package com.lec.ex1_string;

public class Ex10_StringSpeedCheck {
	public static void main(String[] args) {
		//System.out.println("1970.1.1���� ��������� �и�����" + System.currentTimeMillis());
		String str = "a";
		long start = System.currentTimeMillis(); // ���� ������ �и������Ҵ� 
		for(int i=0 ; i<100000 ; i++) {
			str = str.concat("b");
		}
		long end = System.currentTimeMillis(); // ���� ������ �и�����
		System.out.println("��Ʈ�� 10���� ���� ��� �ð� :" + (end-start));
		StringBuffer strBuf = new StringBuffer("a");
		start = System.currentTimeMillis(); // ���۽��� �и�����
		for(int i=0 ; i<100000 ; i++) {
			strBuf.append("b");
		}
		end = System.currentTimeMillis(); // ���� ������ �и�����
		System.out.println("��Ʈ�� ���� 10���� ���� ��� �ð� :" + (end-start));
		StringBuilder strBuil = new StringBuilder("a");
		start = System.currentTimeMillis(); // ���۽��� �и�����
		for(int i=0 ; i<100000 ; i++) {
			strBuil.append("b");
		}
		end = System.currentTimeMillis(); // ���� ������ �и�����
		System.out.println("��Ʈ�� ���� 10���� ���� ��� �ð� :" + (end-start));
	}
}