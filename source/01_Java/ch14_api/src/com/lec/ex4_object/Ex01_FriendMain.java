package com.lec.ex4_object;

public class Ex01_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮"),
						    new Friend("���浿", "010-8867-4599", "12-26", "���� ����"),
						    new Friend("��浿", "010-9921-9929", "02-10", "���� ���"),
						    new Friend("�ű浿", "010-5129-5539", "03-03", "��õ �۵�")};
		for(Friend friend : friends) {
			// �̸� : ȫ�浿 ��ȭ : 010-2312-1312 ���� : 12-14 �ּ� : ���� ���빮 
			System.out.println(friend);
		}
	}
}
