package com.lec.ex;
// �Ǽ��� double�� ����. ����� ������
public class Varex04 {
	public static void main(String[] args) {
		// ���� ������ ��ġ ������ ����. �ٸ� ���� ������ ���� ��õ
		char c = '��'; // 2byte
		int i = 20; // 4byte (int 4����Ʈ double 8����Ʈ �� ����ϱ�)
		long l = 22000000000L; // 8byte
		System.out.println("l = " + l);
		boolean b = true; // 1byte
		System.out.println("b = " + b);
		float f = 3.14159265359F; // 4byte
		double d = 3.14159265359; // 8byte
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if(f == d) {
			System.out.println("f�� d���� ����");
		}else {
			System.out.println("f�� d���� �ٸ���");
		}
		f = 10.1F;
		d = 10.1;
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if(f == d) {
			System.out.println("f�� d���� ����");
		}else {
			System.out.println("f�� d���� �ٸ���");
		}
		// ����(4byte)�� �Ǽ�(8byte)�� ���� i+d : i+d(8byte)
		System.out.println("i + d = " + (i+d));
		// ����(4byte)�� ����(4byte)�� ������ ��� : 4byte
		System.out.println("i / 7 = " + (i/7));
	}
}
