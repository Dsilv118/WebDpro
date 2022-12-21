package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenArray {
	public static void main(String[] args) {
		String str = "�ں��� ���� ���� ��ҿ� �嵿�� ����";
		StringTokenizer tokeneizer = new StringTokenizer(str);
		String[] arr = new String[tokeneizer.countTokens()];
		int idx = 0;
		while(tokeneizer.hasMoreTokens()) {
			arr[idx++] = tokeneizer.nextToken();
		}
		System.out.println("�迭�� ����� ������");
		for(String a : arr) {
			System.out.println(a);
		}
	}
}
