package com.lec.ex5_printwriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex {
	public static void main(String[] args) {
		OutputStream         os = null; // 기본스트림
		Writer            write = null; // 기본스트림
		PrintWriter printWriter = null;
		try {
			// 1. PrintWriter : OutputStream의 보조스트림
//			os = new FileOutputStream("txtFile/outTest.txt");
//			printWriter = new PrintWriter(os); 
			// 2. PrintWriter : Writer의 보조스트림 
//			write = new FileWriter("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(write);
			// 3. PrintWriter를 기본스트림처럼 사용
			printWriter = new PrintWriter("txtFile/outTest.txt"); // append 불가
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\n반갑습니다");
			System.out.print("print는 자동개행이 안돼요. 그래서 개행추가\n");
			printWriter.print("print는 자동개행이 안돼요. 그래서 개행추가\n");
			System.out.printf("%s %3d %3d %5.1f\n", "홍길동", 95, 94, 94.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "홍길동", 95, 95, 94.5);
			System.out.printf("%s %3d %3d %5.1f\n", "신길동", 100, 99, 99.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "신길동", 100, 99, 99.5);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(printWriter!=null) 
					printWriter.close();
				if(write!=null) 
					write.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
