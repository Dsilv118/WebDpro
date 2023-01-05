package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sca = new Scanner(System.in);
		Connection        conn = null;
//		Statement  stmt = null;
		PreparedStatement pstmt = null;
		String qur = "INSERT INTO DEPT VALUES (?, ?, ?)";
		System.out.print("추가할 부서번호는 ?");
		int deptno = sca.nextInt();
		System.out.println("추가할 부서명은 ?");
		String dname = sca.next();
		System.out.println("추가할 근무지는 ?");
		String loc = sca.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(qur); // SQL 전송 객체
			pstmt.setInt(1, deptno); // deptno가 int라서 setInt 함수 이용
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
//			stmt = conn.createStatement(qur);
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? deptno+"번 입력성공" : deptno+"번 입력 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} sca.close();
	}
}
