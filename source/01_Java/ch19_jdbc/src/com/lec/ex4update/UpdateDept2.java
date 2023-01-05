package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재하는 부서번호인지 확인후, 부서명, 근무지 입력받아 update

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sca = new Scanner(System.in);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.println("수정할 부서번호는 ?");
			int deptno = sca.nextInt();
			String sel = "SELECT COUNT(*) FROM DEPT WHERE DEPTNO=" + deptno;
			rs = stmt.executeQuery(sel);
			rs.next();
			int tmp = rs.getInt(1);
			if(tmp!=1) {
				System.out.println("해당 부서번호는 수정이 불가합니다.");
			} else {
				System.out.println("수정할 부서명은 ?");
				String dname = sca.next();
				System.out.println("수정할 근무지는 ?");
				String loc = sca.next();
				String update = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d",
																		dname, loc, deptno);
				int result = stmt.executeUpdate(update);
				System.out.println(result>0 ? "수정성공" : "수정실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)   rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} sca.close();
	} 
}

