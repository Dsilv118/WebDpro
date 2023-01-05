package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �޾� �μ������� �Ѹ���, �ش� �μ��� ��� ������ ��� 
	// 1. �ش� �μ� ��ȣ�� ���� ��� : �������� �ʴ� �μ��Դϴ�
	// 2. �ش� �μ� ��ȣ�� �ִ� ��� : �μ� ������ ���
	//	2-1. �ش� �μ� ����� �ִ� ��� : ��� ���� ���
	//	2-2. �ش� �μ� ����� ���� ��� : �ش� �μ� ���(���, �̸�, �޿�, ����̸�)�� �����ϴ�.

public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs1  = null;
		ResultSet  rs2  = null;
		Scanner sca = new Scanner(System.in);
		System.out.println("���ϴ� �μ� ��ȣ�� ?");
		int deptno = sca.nextInt();
		String sqldn = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sqlif = "SELECT E1.EMPNO, E1.ENAME WOR, E1.SAL, E2.ENAME MAN" + 
						"    FROM EMP E1, EMP E2 " + 
						"    WHERE E1.MGR=E2.EMPNO AND E1.DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs1  = stmt.executeQuery(sqldn);
			if(rs1.next()) {
				String dname = rs1.getString("dname");
				String loc   = rs1.getString("loc");
				System.out.println("�μ� ��ȣ : " + deptno);
				System.out.println("�μ��� : " + dname);
				System.out.println("�μ� ��ġ : " + loc);
				rs2  = stmt.executeQuery(sqlif);
				if(rs2.next()) {
					System.out.println("���\t�̸�\t��å\t�����\t�Ի���\t�޿�\t�󿩱�");
					do {
						int empno     = rs2.getInt("empno");
						String wor  = rs2.getString("wor");
						int    sal    = rs2.getInt("sal");
						String man    = rs2.getString("man");
						System.out.printf("%d\t %s\t %d\t %s\n",
						          empno, wor, sal, man);
					} while(rs2.next());
				} else {
					System.out.println("�ش� �μ� ����� �����ϴ�");
				}
			} else {
				System.out.println("�������� �ʴ� �μ��Դϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs2!=null) rs2.close();
				if(rs1!=null) rs1.close();
				if(stmt!=null) stmt.close(); 
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}	
}















