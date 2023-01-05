package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재하는 부서번호인지 확인후, 부서명, 근무지 입력받아 update

public class Ex4_UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sca = new Scanner(System.in);
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet          rs   = null;
		String sel = "SELECT COUNT(*) FROM DEPT WHERE DEPTNO=?";
		String update = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		try {
			Class.forName(driver);
			conn  = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sel);
			System.out.println("수정할 부서번호는 ?");
			int deptno = sca.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int tmp = rs.getInt(1);
			if(tmp!=1) {
				System.out.println("해당 부서번호는 수정이 불가합니다.");
			} else {
				System.out.println("수정할 부서명은 ?");
				String dname = sca.next();
				System.out.println("수정할 근무지는 ?");
				String loc = sca.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(update);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "수정성공" : "수정실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} sca.close();
	} 
}

