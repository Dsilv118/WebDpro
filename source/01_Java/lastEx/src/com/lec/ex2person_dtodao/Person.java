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
			System.out.print("1:데이터 입력 / 2:원하는 직업명 조회 / 3:전체 조회 / 그외 키 종료");
			fn = sca.next();
			switch(fn) {
			case "1" :
				System.out.println("입력할 이름은 ?");
				String pname = sca.next();
				System.out.println("입력할 직업"+jobs+"은 ?");
				String jname = sca.next();
				System.out.println("입력할 국어 점수는 ?");
				int kor = sca.nextInt();
				System.out.println("입력할 영어 점수는 ?");
				int eng = sca.nextInt();
				System.out.println("입력할 수학 점수는 ?");
				int mat = sca.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				break;
			case "2" :
				System.out.println("조회 하고싶은 직업명을 입력하세요 직업 목록 :" + jobs);
				String job = sca.next();
				ArrayList<PersonDto> dtos = dao.selectJname(job);
				if(dtos.isEmpty()) {
					System.out.println(job + "직업군의 사람은 없습니다");
				} else {
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				} 
				break;
			case "3" :
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					System.out.println("등록된 사람이 없습니다");
				} else {
					for(int idx=0 ; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
				}
				 break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("종료되었습니다.");
		sca.close();
	} 
}
