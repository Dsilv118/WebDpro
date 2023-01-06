package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 메소드1, 메소드2, 메소드3, 메소드4

public class PersonDao {
	// 변수 - 생성자 - 메소드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL    = 0;
	private static PersonDao INSTANCE;
	public static PersonDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new PersonDao(); 
		}
		return INSTANCE;
	}
	private PersonDao () {
		try {
			Class.forName(driver); // 1단계는 생성자에서 한번
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류 : " + e.getMessage());
		} 
	}
	// 1번 기능 dto(이름, 직업명, 국영수)를 받아 DB에 insert하고 return SUCCESS/FAIL을 return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection conn         = null;
		PreparedStatement pstmt = null;
		String qur = "INSERT INTO PERSON" + 
					 " VALUES (PSQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?)," + 
					 " ?,?,?)";
		try {
			conn  = DriverManager.getConnection(url, "scott", "tiger"); // 2단계
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "입력 성공" : "입력 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return result;
	}
	// 2번 기능 직업명을 받아 DB에 select 한 결과를 ArrayList<PersonDto> return
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB 결과를 dtos에 add한다
		Connection         conn = null; 
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String qur = "SELECT ROWNUM || '등' RW, A.*" + 
						" FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR" + 
						" FROM PERSON P, JOB J" + 
						" WHERE P.JNO=J.JNO AND JNAME=?" + 
						" ORDER BY SCR DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String    rw = rs.getString("rw");
				String pname = rs.getString("pname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int scr = rs.getInt("scr");
				dtos.add(new PersonDto(rw, pname, jname, kor, eng, mat, scr));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 3번 기능 DB에 전체 select한 결과를 ArrayList<PersonDto>로 return
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String qur = "SELECT ROWNUM || '등' RW, A.*" + 
						" FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SCR" + 
						" FROM PERSON P, JOB J" + 
						" WHERE P.JNO=J.JNO" + 
						" ORDER BY SCR DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(qur);
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRw(rs.getString("rw"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setScr(rs.getInt("scr"));
				dtos.add(dto);
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
		}
		return dtos;
	}
	// jname을 ArrayList<String>로 return
	public ArrayList<String> jnameList() {
		ArrayList<String> jnames = new ArrayList<String>();
		Connection          conn = null;
		PreparedStatement  pstmt = null;
		ResultSet             rs = null;
		String qur = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames; 
	}
}



















