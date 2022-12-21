package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenArray {
	public static void main(String[] args) {
		String str = "박보검 설현 수지 고소영 장동건 공유";
		StringTokenizer tokeneizer = new StringTokenizer(str);
		String[] arr = new String[tokeneizer.countTokens()];
		int idx = 0;
		while(tokeneizer.hasMoreTokens()) {
			arr[idx++] = tokeneizer.nextToken();
		}
		System.out.println("배열에 제대로 들어갔는지");
		for(String a : arr) {
			System.out.println(a);
		}
	}
}
