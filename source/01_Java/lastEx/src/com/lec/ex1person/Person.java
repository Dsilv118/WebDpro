package com.lec.ex1person;

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
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sca = new Scanner(System.in);
		Connection         conn = null;
		PreparedStatement pstmt = null;
		Statement          stmt = null;
		ResultSet          rs   = null;
		ArrayList<String>  jobs = new ArrayList<String>();
		String fn, qur;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			qur = "SELECT JNAME FROM JOB";
			rs = stmt.executeQuery(qur);
			while (rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				
			}
		}
		do {
			System.out.print("1:������ �Է� / 2:���ϴ� ������ ��ȸ / 3:��ü ��ȸ / �׿� Ű ����");
			fn = sca.next();
			switch(fn) {
			case "1" :
				qur = "INSERT INTO PERSON " + 
						"VALUES (PSQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), " + 
						"?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(qur);
					System.out.println("�Է��� �̸��� ?");
					String jname = sca.next();
					System.out.println("�Է��� ����"+jobs+"�� ?");
					String jno = sca.next();
					System.out.println("�Է��� ���� ������ ?");
					int kor = sca.nextInt();
					System.out.println("�Է��� ���� ������ ?");
					int eng = sca.nextInt();
					System.out.println("�Է��� ���� ������ ?");
					int mat = sca.nextInt();
					pstmt.setString(1, jname);
					pstmt.setString(2, jno);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է� ����":"�Է� ����");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs  !=null) rs.close();
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} break;
			case "2" :
				System.out.println("��ȸ �ϰ���� �������� �Է��ϼ��� ���� ��� :" + jobs);
				String job = sca.next();
				qur = "SELECT ROWNUM || '��' RW, A.*" + 
						"    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR" + 
						"    FROM PERSON P, JOB J" + 
						"    WHERE P.JNO=J.JNO AND JNAME=" + "'" + job + "'" + 
						"    ORDER BY SCR DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(qur);
					if(rs.next()) {
						System.out.println("���\t�̸�\t������\t����\t����\t����\t����");
						do {
							String rw = rs.getString("rw");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int scr = rs.getInt("scr");
							System.out.printf("%s\t %s\t %s\t %d\t %d\t %d\t %d\n",
												rw, pname, jname, kor, eng, mat, scr);
						} while(rs.next());
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close(); 
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} break;
			case "3" :
				qur = "SELECT ROWNUM || '��' RW, A.*" + 
						" FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR" + 
						" FROM PERSON P, JOB J" + 
						" WHERE P.JNO=J.JNO" + 
						" ORDER BY SCR DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(qur);
					if(rs.next()) {
						System.out.println("���\t�̸�\t������\t����\t����\t����\t����");
						do {
							String rw = rs.getString("rw");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int scr = rs.getInt("scr");
							System.out.printf("%s\t %s\t %s\t %d\t %d\t %d\t %d\n",
												rw, pname, jname, kor, eng, mat, scr);
						} while(rs.next());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close(); 
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("����Ǿ����ϴ�.");
		sca.close();
	} 
}
