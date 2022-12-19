package com.lec.ex1_inputstreamoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1)파일을 연다(스트림 객체 생성) (2)데이터 읽는다(read 메소드 사용) (3)파일을 닫는다(close 메소드 사용)

public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일을 연다 
			// 2. 데이터를 읽는다(파일 끝까지 1byte씩 반복적으로 읽는다)
			while(true) {
				int i = is.read(); // 1byte씩 읽기
				if(i==-1)
					break; // 파일의 끝이면 break;
				System.out.print((char)i + "(" + i + ")");
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			System.out.println("예외메세지 : 파일을 못 찾음 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("예외메세지 : 못 읽음 " + e.getMessage());
		} finally {
			// 3. 파일을 닫는다
			try {
				if(is!=null) 
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}// try-catch-finally
	}// main
}
