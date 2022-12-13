package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 뒷자리를 입력받아 검색된 전화번호(중복된 뒷자리 가능)를 출력

public class Ex07_searchPostTel {
	public static void main(String[] args) {
		String[] tels = {"010-4444-4444", "02-123-1234", "010-5512-9999", "010-4412-9999"};
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOK = false; // 검색한 결과가 있으면 true
			System.out.println("검색하고자 하는 전화번호 뒷자리?(종료는 x)"); // 8888
			String searchTel = sc.next();
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(int i=0 ; i<tels.length ; i++) {
	//			int idx = tels[i].lastIndexOf("-"); // 8,6...
	//			String postTel = tels[i].substring(idx+1);
	//			System.out.println(i+"번째 뒷자리 : " + postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-")+1);
				if(postTel.equals(searchTel)) {
					System.out.println("검색하신 전화번호는" + tels[i]);
					searchOK = true; // 전화번호 출력여부
				}
			}
			if(!searchOK) {
				System.out.println("검색하신 전화번호 뒷자리는 없습니다");
			}
		}	
	}
}











