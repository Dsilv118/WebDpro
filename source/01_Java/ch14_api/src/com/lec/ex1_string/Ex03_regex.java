package com.lec.ex1_string;

public class Ex03_regex {
	public static void main(String[] args) {
		/* 정규표현식(regex)
		   1.참조 
		   
		   2.간략문법
		   \d   (숫자와 매치, [0-9]와 동일)
		   \D   (숫자가 아닌 것)
		   \w   (영문자나 숫자, [A-Za-z0-9]와 동일)
		   \W   (영문자나 숫자가 아닌 문자)
		   .    (\n을 제외한 문자)
		   \    특정한 문자로 인식하고 싶다하면 역슬래쉬
		   {2,}  (2번 이상 반복)
		   {2,4} (2~4회 반복)
		   +    (1번 이상 반복)
		   *    (0번 이상 반복)
		   ?    (0번이나 1번 반복 의미)
		   
		   3.정규표현식 연습장 : https://www.regexpal.com/
		       ex1. 전화번호 : 02 712 6100 / 010 9999 9999 / 010-9999-9999 / 010.9999.9999 / 02)717.6541 
		       => \d{2,3}.\d{3,4}.\d{4}   
		       ex2. 주민등록번호 : 980118-1938551  
		       => \d{2}[0-1]\d[0-3]\d-[1-4]\d{6}                                                           
		       ex3. 이메일 : yi09@naver.com / yi@sec.co.kr
		       => \w+@\w+(\.\w+){1,2}
		   4.소스 구현
		 */
		String juminNo = "980118-1938551";
		// 특정 정규표현식의 문자열 변경
		System.out.println("주민번호 : " + juminNo.replaceAll("[1-4][0-9]{6}", "*******"));
		String str = "010-9999-9999 yisy0703@naver.com 반갑습니다. 980118-1092541 ㅋㅋ ㅎㅎ";
		System.out.println("이메일 지움 str : " + str.replaceAll("\\w+@\\w+(\\.\\w+){1,2}", ""));
		System.out.println("전화번호 삭제된 str : " + str.replaceAll("\\d{2,3}.\\d{3,4}.\\d{4}", ""));
		System.out.println("자음 제거된 str : " + str.replaceAll("[ㄱ-ㅎ]", "하하"));
	}
}
