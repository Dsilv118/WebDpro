package com.lec.ch11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ch11.dto.BoardDto;

public class BoardDao {
	private final int SUCCESS = 1;
	private final int FAIL    = 0;
	private DataSource ds;
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 글 목록
	public ArrayList<BoardDto> list(int startRow, int endRow) {
		ArrayList<BoardDto> bdto = new ArrayList<BoardDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * " + 
					 "    FROM (SELECT ROWNUM RW, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
					 "    WHERE RW BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int       bid      = rs.getInt("bid");
				String    bname    = rs.getString("bname");
				String    btitle   = rs.getString("btitle");
				String    bcontent = rs.getString("bcontent");
				Timestamp bdate    = rs.getTimestamp("bdate");
				int       bhit     = rs.getInt("bhit");
				int       bgroup   = rs.getInt("bgroup");
				int       bstep    = rs.getInt("bstep");
				int       bindent  = rs.getInt("bindent");
				String    bip      = rs.getString("bip");
				bdto.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
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
	// 2. 전체 글 갯수
	public int getBoardTotCnt() {
		int totCnt = 0;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		try {
			conn = ds.getConnection();
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
	// 3. 원글 쓰기 (bname, btitle, bcontent, bip)
	public int write(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 "    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
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
	// 3. 원글 쓰기 (bname, btitle, bcontent, bip)
	public int write(BoardDto bDto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 "    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setString(4, bDto.getBip());
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
	// 4. BID로 조회수 1 올리기
	private void hitUp(int bid) {
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD " + 
					 "    SET BHIT = BHIT + 1" + 
					 "    WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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
	// 5-1. BID로 DTO 가져오기(상세보기) -- 조회수 올리고 dto 가져오기
	public BoardDto content(int bid) {
		BoardDto dto = null;
		hitUp(bid); // 글 상세보기 시 조회수 1 올리기
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * " + 
					 "    FROM MVC_BOARD " + 
					 "    WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String    bname    = rs.getString("bname");
				String    btitle   = rs.getString("btitle");
				String    bcontent = rs.getString("bcontent");
				Timestamp bdate    = rs.getTimestamp("bdate");
				int       bhit     = rs.getInt("bhit");
				int       bgroup   = rs.getInt("bgroup");
				int       bstep    = rs.getInt("bstep");
				int       bindent  = rs.getInt("bindent");
				String    bip      = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
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
	// 5-2. BID로 DTO 가져오기(글 수정 view, 답변 글 view) -- dto 가져오기
	public BoardDto modifyView_replyView(int bid) {
		BoardDto dto = null;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * " + 
					 "    FROM MVC_BOARD " + 
					 "    WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String    bname    = rs.getString("bname");
				String    btitle   = rs.getString("btitle");
				String    bcontent = rs.getString("bcontent");
				Timestamp bdate    = rs.getTimestamp("bdate");
				int       bhit     = rs.getInt("bhit");
				int       bgroup   = rs.getInt("bgroup");
				int       bstep    = rs.getInt("bstep");
				int       bindent  = rs.getInt("bindent");
				String    bip      = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
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
	// 6. 글 수정하기 (특정 bid의 작성자, 글제목, 글본문, bip만 수정)
	public int modify(int bid, String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD " + 
					 "    SET BNAME = ?, " + 
					 "        BTITLE = ?, " + 
					 "        BCONTENT = ?, " + 
					 "        BIP = ? " + 
					 "    WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);
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
	// 6. 글 수정하기 (특정 bid의 작성자, 글제목, 글본문, bip만 수정)
	public int modify(BoardDto bDto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD " + 
					 "    SET BNAME = ?, " + 
					 "        BTITLE = ?, " + 
					 "        BCONTENT = ?, " + 
					 "        BIP = ? " + 
					 "    WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setString(4, bDto.getBip());
			pstmt.setInt(5, bDto.getBid());
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
	// 7. 글 삭제하기
	public int delete(int bid) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD " + 
					 "    WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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
	// 8. 답변글 저장 전 작업 (STEP a)
	private void preReplyStep(int bgroup, int bstep) {
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD " + 
					 "    SET BSTEP = BSTEP+1 " + 
					 "    WHERE BGROUP = ? AND BSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
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
	// 9. 답변글 쓰기
	//		답변글쓴이    : bname, btitle, bcontent
	// 		시스템적으로 : bid
	//		원글 		 : bgroup, bstep, bindent 
	public int reply(String bname, String btitle, String bcontent, String bip, int bgroup, int bstep, int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)\r\n" + 
					 "    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bip);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("답변글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글쓰기 실패");
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
	public int reply(BoardDto bDto) {
		int result = FAIL;
		preReplyStep(bDto.getBgroup(), bDto.getBstep());
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)\r\n" + 
					 "    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getBtitle());
			pstmt.setString(3, bDto.getBcontent());
			pstmt.setInt(4, bDto.getBgroup());
			pstmt.setInt(5, bDto.getBstep()+1);
			pstmt.setInt(6, bDto.getBindent()+1);
			pstmt.setString(7, bDto.getBip());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("답변글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글쓰기 실패");
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


































