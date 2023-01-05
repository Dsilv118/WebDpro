package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 부서 이름을 입력받아 부서 정보 출력

public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sca = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		System.out.println("원하는 부서이름은?");
		String dname = sca.next();
		String qr = "SELECT * FROM DEPT WHERE DNAME=UPPER('"+dname+"')";
			   qr = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qr); // stmt.executeQuery() : select문 전송시
			if(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 : " + dname);
				System.out.println("근무지 : " + rs.getString("loc"));
			} else {
				System.out.println("해당 부서 이름이 존재하지 않습니다");
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
		} 
		sca.close();
	}
}
