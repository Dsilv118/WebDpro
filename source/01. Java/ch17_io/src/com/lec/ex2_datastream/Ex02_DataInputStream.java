package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// DataInputStream�� inputStream�� ���� ��Ʈ��

public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream     fis = null;
		DataInputStream fds = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			fds = new DataInputStream(fis);
			while(true) {
				String name = fds.readUTF();
				int grade   = fds.readInt();
				double score = fds.readDouble();
				System.out.printf("%s�� %d�г� %.1f��\n", name, grade, score);
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		} finally {
			try {
				if(fds!=null) fds.close();
				if(fis!=null) fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
