package com.lec.ex2person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// �޼ҵ�1, �޼ҵ�2, �޼ҵ�3, �޼ҵ�4

public class PersonDao {
	// ���� - ������ - �޼ҵ�
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
			Class.forName(driver); // 1�ܰ�� �����ڿ��� �ѹ�
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� : " + e.getMessage());
		} 
	}
	// 1�� ��� dto(�̸�, ������, ������)�� �޾� DB�� insert�ϰ� return SUCCESS/FAIL�� return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection conn         = null;
		PreparedStatement pstmt = null;
		String qur = "INSERT INTO PERSON" + 
					 " VALUES (PSQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?)," + 
					 " ?,?,?)";
		try {
			conn  = DriverManager.getConnection(url, "scott", "tiger"); // 2�ܰ�
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "�Է� ����" : "�Է� ����");
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
	// 2�� ��� �������� �޾� DB�� select �� ����� ArrayList<PersonDto> return
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB ����� dtos�� add�Ѵ�
		Connection         conn = null; 
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String qur = "SELECT ROWNUM || '��' RW, A.*" + 
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
	// 3�� ��� DB�� ��ü select�� ����� ArrayList<PersonDto>�� return
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String qur = "SELECT ROWNUM || '��' RW, A.*" + 
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
	// jname�� ArrayList<String>�� return
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



















