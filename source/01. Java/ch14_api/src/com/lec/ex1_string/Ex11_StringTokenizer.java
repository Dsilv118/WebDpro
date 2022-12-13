package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex11_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 고소영 장동건";
		String str2 = "100/90/85/76";
		StringTokenizer tokenizer1 = new StringTokenizer(str1); //구분자는 space
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "/"); // 구분자는 / (스페이스가 아니면 써 줘야됨)
		System.out.println("tokenizer1의 토큰 갯수 :" + tokenizer1.countTokens());
		System.out.println("tokenizer2의 토큰 객수 :" + tokenizer2.countTokens());
		while(tokenizer1.hasMoreTokens()) {
			System.out.print(tokenizer1.nextToken() + "\t");
		}
		while(tokenizer2.hasMoreTokens()) {
			System.out.print(tokenizer2.nextToken() + "\t");
		}
	}
}
