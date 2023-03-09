package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.MemberDto;

public class MemberDao {
	public static int SUCCESS = 1;
	public static int FAIL    = 0;
	public static int DUPLI         = 1;
	public static int NONE_DUPLI    = 0;
	private static MemberDao INSTANCE = new MemberDao();
	public static MemberDao getInstance() {
		return INSTANCE;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// -- 1. id 중복 체크
	public int idConfirm(String mid) {
		int result = DUPLI;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) FROM MVC_MEMBER WHERE MID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				result = DUPLI;
			} else {
				result = NONE_DUPLI;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// -- 2. 회원가입
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS) " + 
				"    VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpw());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getMemail());
			pstmt.setString(5, dto.getMphoto());
			pstmt.setDate(6, dto.getMbirth());
			pstmt.setString(7, dto.getMaddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원가입 성공" : "회원가입 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 : " + dto);
		} finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(conn  !=null) conn.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// -- 3. login check
	public int loginChk(String mid, String mpw) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=? AND MPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				result = SUCCESS;
			} else {
				result = FAIL;
			}
			System.out.println("로그인 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// -- 4. id로 MemberDto 가져오기
	public MemberDto getMember(String mid) {
		MemberDto dto = null;
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, mid);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String mpw       = rs.getString("mpw");
				String mname     = rs.getString("mname");
				String memail    = rs.getString("memail");
				String mphoto    = rs.getString("mphoto");
				Date   mbirth    = rs.getDate("mbirth");
				String maddress  = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn  !=null) conn.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
}































