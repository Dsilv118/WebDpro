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

import com.lec.dto.BookDto;
import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	public static int SUCCESS = 1;
	public static int FAIL    = 0;
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
	// -- 1. TOP-N 리스트
	// -- 1-1. 등록된 게시글 갯수
	public int getBoardNum() {
		int totalCnt = 0;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
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
	// -- 1-2. TOP-N 구문 (페이징)
	public ArrayList<FileBoardDto> BoardList(int startRow, int endRow) {
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "    SELECT * " + 
					 "        FROM (SELECT ROWNUM RW, A.* FROM (SELECT F.*, cNAME, cEMAIL " + 
					 "                                              FROM CUSTOMER C, FILEBOARD F " + 
					 "                                              WHERE C.cID = F.cID ORDER BY fREF DESC, fRE_STEP) A) " + 
					 "        WHERE RW BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    fnum      = rs.getInt("fnum");
				String cid       = rs.getString("cid");
				String fsubject  = rs.getString("fsubject");
				String fcontent  = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw       = rs.getString("fpw");
				int    fhit      = rs.getInt("fhit");
				int    fref      = rs.getInt("fref");
				int    fre_step  = rs.getInt("fre_step");
				int    fre_level = rs.getInt("fre_level");
				String fip       = rs.getString("fip");
				Date   frdate    = rs.getDate("frdate");
				String cname     = rs.getString("cname");
				String cemail    = rs.getString("cemail");
				dtos.add(new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, 
										  fre_step, fre_level, fip, frdate, cname, cemail));
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
	// -- 2. 글 쓰기 
	public int insertBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP) " + 
					 "    VALUES (FN_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, FN_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFhit());
			pstmt.setString(7, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "게시글 작성 성공" : "게시글 작성 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("게시글 작성 실패" + dto);
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
	// -- 3. 조회수 올리기
	public void hitUp(int num) {
		Connection        conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT + 1 " + 
					 "    WHERE cID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "조회수 증가" : "조회수 증가 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// -- 4. 글 상세보기
	public FileBoardDto getBoard(int fnum) {
		FileBoardDto        dto = null;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * FROM FILEBOARD WHERE fNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			String cid       = rs.getString("cid");
			String fsubject  = rs.getString("fsubject");
			String fcontent  = rs.getString("fcontent");
			String ffilename = rs.getString("ffilename");
			String fpw       = rs.getString("fpw");
			int    fhit      = rs.getInt("fhit");
			int    fref      = rs.getInt("fref");
			int    fre_step  = rs.getInt("fre_step");
			int    fre_level = rs.getInt("fre_level");
			String fip       = rs.getString("fip");
			Date   frdate    = rs.getDate("frdate");
			String cname     = rs.getString("cname");
			String cemail    = rs.getString("cemail");
			dto = new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, 
								   fref, fre_step, fre_level, fip, frdate, cname, cemail);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dto;
	}
	// -- 5. 글 수정
	public int updateBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSUBJECT  = ?, " + 
					 "                     fCONTENT  = ?, " + 
					 "                     fFILENAME = ?, " + 
					 "                     fPW       = ? " + 
					 "    WHERE fNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setInt(5, dto.getFnum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	// -- 6. 글 삭제
	public int deleteBoard(int num, String pw) {
		int result = FAIL;
		Connection        conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE cID = ? AND fPW = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글 삭제 완료" : "글 삭제 실패(비번확인)");
		} catch (SQLException e) {
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
}


































