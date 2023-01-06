package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		ArrayList<String>  jobs = dao.jnameList();
	    String fn;
		do {
			System.out.print("1:������ �Է� / 2:���ϴ� ������ ��ȸ / 3:��ü ��ȸ / �׿� Ű ����");
			fn = sca.next();
			switch(fn) {
			case "1" :
				System.out.println("�Է��� �̸��� ?");
				String pname = sca.next();
				System.out.println("�Է��� ����"+jobs+"�� ?");
				String jname = sca.next();
				System.out.println("�Է��� ���� ������ ?");
				int kor = sca.nextInt();
				System.out.println("�Է��� ���� ������ ?");
				int eng = sca.nextInt();
				System.out.println("�Է��� ���� ������ ?");
				int mat = sca.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				break;
			case "2" :
				System.out.println("��ȸ �ϰ���� �������� �Է��ϼ��� ���� ��� :" + jobs);
				String job = sca.next();
				ArrayList<PersonDto> dtos = dao.selectJname(job);
				if(dtos.isEmpty()) {
					System.out.println(job + "�������� ����� �����ϴ�");
				} else {
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				} 
				break;
			case "3" :
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					System.out.println("��ϵ� ����� �����ϴ�");
				} else {
					for(int idx=0 ; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
				}
				 break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("����Ǿ����ϴ�.");
		sca.close();
	} 
}
