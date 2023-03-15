package com.lec.ex.dao;

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

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static int SUCCESS = 1;
	public static int FAIL    = 0;
	private static BoardDao INSTANCE = new BoardDao();
	public static BoardDao getInstance() {
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
	// -- 1. 글 목록 (startRow ~ endRow)
	public ArrayList<BoardDto> list(int startRow, int endRow) {
		ArrayList<BoardDto> bdto = new ArrayList<BoardDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * " + 
					 "    FROM (SELECT ROWNUM RW, A.* FROM (SELECT F.*, MNAME " + 
					 "                                        FROM FILEBOARD F, MVC_MEMBER M " + 
					 "                                        WHERE F.mID = M.mID " + 
					 "                                        ORDER BY fGROUP DESC, fSTEP) A) " + 
					 "    WHERE RW BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    fid       = rs.getInt("fid");
				String mid       = rs.getString("mid");
				String ftitle    = rs.getString("ftitle");
				String fcontent  = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date   frdate    = rs.getDate("frdate");
				int    fhit      = rs.getInt("fhit");
				int    fgroup    = rs.getInt("fgroup");
				int    fstep     = rs.getInt("fstep");
				int    findent   = rs.getInt("findent");
				String fip       = rs.getString("fip");
				String mname     = rs.getString("mname");
				bdto.add(new BoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "list 오류");
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return bdto;
	}
	// -- 1-1. 등록된 글 갯수  
	public int getBoardTotCnt() {
		int totCnt = 0;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) CN FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "totCnt 오류");
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	// -- 2. 원글쓰기
	public int write(BoardDto bDto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP) " + 
					 "    VALUES (FILE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 0, FILE_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getMid());
			pstmt.setString(2, bDto.getFtitle());
			pstmt.setString(3, bDto.getFcontent());
			pstmt.setString(4, bDto.getFfilename());
			pstmt.setDate(5, bDto.getFrdate());
			pstmt.setString(6, bDto.getFip());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글쓰기 실패");
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
	// -- 3. hit 1회 올리기
	private void hitUp(int fid) {
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD " + 
					 "    SET fHIT = fHIT + 1 " + 
					 "    WHERE fID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "조휘수 up 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} 
	}
	// -- 4. 글번호(fid)로 글 전체 내용(BoardDto) 가져오기 (글 상세보기)
	public BoardDto content(int fid) {
		BoardDto dto = null;
		hitUp(fid);
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT F.*, MNAME " + 
					 "    FROM FILEBOARD F, MVC_MEMBER M " + 
					 "    WHERE F.mID = M.mID AND fID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid       = rs.getString("mid");
				String ftitle    = rs.getString("ftitle");
				String fcontent  = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date   frdate    = rs.getDate("frdate");
				int    fhit      = rs.getInt("fhit");
				int    fgroup    = rs.getInt("fgroup");
				int    fstep     = rs.getInt("fstep");
				int    findent   = rs.getInt("findent");
				String fip       = rs.getString("fip");
				String mname     = rs.getString("mname");
				dto = new BoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mname);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// -- 5. 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(sysdate), fip 수정)
	public int modify(int fid, String ftitle, String fcontent, String ffilename, Date frdate, String fip) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fTITLE = ?, " + 
					 "                     fCONTENT = ?, " + 
					 "                     fFILENAME = ?, " + 
					 "                     frdate = ?, " + 
					 "                     fIP = ? " + 
					 "    WHERE fID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ftitle);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffilename);
			pstmt.setDate(4, frdate);
			pstmt.setString(5, fip);
			pstmt.setInt(6, fid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글 수정 성공" : "글 번호(BID) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 수정 실패");
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
	// -- 6. 글 삭제하기 (fid로)
	public int deleteBoard(int fid) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD " + 
					 "    WHERE fID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글 삭제 성공" : "글 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 삭제 실패");
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
	// -- 7. 답변글 쓰기 전 작업 (원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
	private void preReplyStep(int fgroup, int fstep) {
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD " + 
					 "    SET fSTEP = fSTEP + 1 " + 
					 "    WHERE fGROUP = ? AND fSTEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "preReplyStep에서 오류");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} 
	}
	// -- 8. 답변글 쓰기
	public int replyBoard(BoardDto bDto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fRDATE, fHIT, fGROUP, fSTEP, fINDENT, fIP) " + 
					 "    VALUES (FILE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getMid());
			pstmt.setString(2, bDto.getFtitle());
			pstmt.setString(3, bDto.getFcontent());
			pstmt.setString(4, bDto.getFfilename());
			pstmt.setDate(5, bDto.getFrdate());
			pstmt.setInt(6, bDto.getFgroup());
			pstmt.setInt(7, bDto.getFstep()+1);
			pstmt.setInt(8, bDto.getFindent()+1);
			pstmt.setString(9, bDto.getFip());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글쓰기 실패");
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
	// -- 9. 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기 (return값 void)
	public void deleteAllBoard(String mid) {
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD " + 
					 "    WHERE mID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			int result = pstmt.executeUpdate();
			System.out.println(result != FAIL ? "글 삭제 성공" : "글 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 삭제 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} 		
	}
}















