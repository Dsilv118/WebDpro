package com.lec.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// 파일 이름과 파일 출력 message를 콘솔로 입력

public class Ex03 {
	public static void main(String[] args) {
		Writer writer = null;
		Scanner sca = new Scanner(System.in);
		System.out.println("저장될 파일 이름은?");
		String filename =  sca.next(); // 파일 이름 받기 abc => txtFile/abc.txt
		sca.nextLine(); // 버퍼 지우는 용도
		try {
			writer = new FileWriter("txtFile/"+filename+".txt");
			while(true) {
				System.out.println("파일로 출력할 메세지 (종료:x) : ");
				String msg = sca.nextLine();
				if(msg.equalsIgnoreCase("x"))
					break;
				writer.write(msg + "\n");
			}
			System.out.println("txtFile/"+filename+".txt 파일명으로 저장 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		sca.close();
	}
}
