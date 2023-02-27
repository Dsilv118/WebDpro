package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDao {
	public static final int CUS_DUP    = 0;
	public static final int CUS_NONDUP = 1;
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	// 싱글톤 
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	// 커넥션 풀
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// -- 아이디 중복 체크
	public int cidChk(String cid) {
		int result = CUS_DUP;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER WHERE cID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			rs.next();
			int dup = rs.getInt(1);
			if(dup == 1) {
				result = CUS_DUP;
			} else {
				result = CUS_NONDUP;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// -- 2. 회원가입
	public int signUp(CustomerDto dto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH) " + 
					 "    VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setDate(8, dto.getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원가입 성공" : "회원가입 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패" + dto);
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
	// -- 3. 로그인
	public int cusLogin(String cid, String cpw) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE cID=? AND cPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			} else {
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	// -- 4. 상세보기
	public CustomerDto getCustomer(String cid) {
		CustomerDto         dto = null;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE cID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cpw      = rs.getString("cpw");
				String cname    = rs.getString("cname");
				String ctel     = rs.getString("ctel");
				String cemail   = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				String cgender  = rs.getString("cgender");
				Date cbirth     = rs.getDate("cbirth");
				Date crdate     = rs.getDate("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
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
	// -- 5. TOP-N 리스트
	// -- 5-1. 등록된 회원수
	public int getSignupNum() {
		int totalCnt = 0;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
	// -- 5-2. 회원리스트
	public ArrayList<CustomerDto> cusList(int startRow, int endRow) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "    SELECT * " + 
					 "        FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM CUSTOMER ORDER BY cRDATE) A) " + 
					 "        WHERE RW BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid      = rs.getString("cid");
				String cpw      = rs.getString("cpw");
				String cname    = rs.getString("cname");
				String ctel     = rs.getString("ctel");
				String cemail   = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				String cgender  = rs.getString("cgender");
				Date cbirth     = rs.getDate("cbirth");
				Date crdate     = rs.getDate("crdate");
				dtos.add(new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// -- 6. 회원정보 수정
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPW = ?, " + 
					 "                    cNAME = ?, " + 
					 "                    cTEL = ?, " + 
					 "                    cEMAIL = ?, " + 
					 "                    cADDRESS = ?, " + 
					 "                    cGENDER = ?, " + 
					 "                    cBIRTH = ? " + 
					 "    WHERE cID=?";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setString(6, dto.getCgender());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원수정 성공" : "회원수정 실패('" + dto.getCid() + "'라는 id는 없습니다");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패 : " + dto);
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
}




































