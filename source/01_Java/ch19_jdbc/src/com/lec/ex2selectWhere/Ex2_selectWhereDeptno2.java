package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 받아 부서정보를 뿌리고, 해당 부서의 사원 정보도 출력 
	// 1. 해당 부서 번호가 없는 경우 : 존재하지 않는 부서입니다
	// 2. 해당 부서 번호가 있는 경우 : 부서 정보를 출력
	//	2-1. 해당 부서 사원이 있는 경우 : 사원 정보 출력
	//	2-2. 해당 부서 사원이 없는 경우 : 해당 부서 사원(사번, 이름, 급여, 상사이름)이 없습니다.

public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs1  = null;
		ResultSet  rs2  = null;
		Scanner sca = new Scanner(System.in);
		System.out.println("원하는 부서 번호는 ?");
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
				System.out.println("부서 번호 : " + deptno);
				System.out.println("부서명 : " + dname);
				System.out.println("부서 위치 : " + loc);
				rs2  = stmt.executeQuery(sqlif);
				if(rs2.next()) {
					System.out.println("사번\t이름\t직책\t상사사번\t입사일\t급여\t상여금");
					do {
						int empno     = rs2.getInt("empno");
						String wor  = rs2.getString("wor");
						int    sal    = rs2.getInt("sal");
						String man    = rs2.getString("man");
						System.out.printf("%d\t %s\t %d\t %s\n",
						          empno, wor, sal, man);
					} while(rs2.next());
				} else {
					System.out.println("해당 부서 사원이 없습니다");
				}
			} else {
				System.out.println("존재하지 않는 부서입니다");
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















