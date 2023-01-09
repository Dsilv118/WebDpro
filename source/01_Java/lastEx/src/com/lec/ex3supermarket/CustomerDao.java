package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
	// dao는 싱글톤으로 구현 / private 생성자에는 driver 로드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL    = 0;
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	private CustomerDao () {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 회원가입 : public int insertCustomer(String CTEL, String CNAME)
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String qur = "INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, ?, ?, 1000, 0, 1)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, dto.getCtel());
			pstmt.setString(2, dto.getCname());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("에러 : "+e.getMessage());
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
    //	   		   public int insertCustomer(CustomerDto dto)
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String qur = "INSERT INTO CUSTOMER VALUES (CUSEQ.NEXTVAL, ?, ?, 1000, 0, 1)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
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
	// 2. 폰 뒤 4자리 검색 : public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet          rs   = null;
		String qur = "SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME," + 
				   		" (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND" + 
				   		" FROM CUSTOMER C, CUSGRADE CU" + 
				   		" WHERE C.CGID=CU.CGID AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				 int cid       = rs.getInt("cid");
//				 String ctel   = rs.getString("ctel");
//				 String cname  = rs.getString("cname");
//				 int cpoint    = rs.getInt("cpoint");
//				 int cbuy      = rs.getInt("cbuy");
//				 String cgname = rs.getString("cgname");
//				 int grnd      = rs.getInt("grnd");
//				 dtos.add(new CustomerDto(cid, ctel, cname, cpoint, cbuy, cgname, grnd));
				 CustomerDto dto = new CustomerDto();
				 dto.setCid(rs.getInt("cid"));
				 dto.setCtel(rs.getString("ctel"));
				 dto.setCname(rs.getString("cname"));
				 dto.setCpoint(rs.getInt("cpoint"));
				 dto.setCbuy(rs.getInt("cbuy"));
				 dto.setCgname(rs.getString("cgname"));
				 dto.setGrnd(rs.getInt("grnd"));
				 dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 3. 물품 구입 : (CID, PRICE 입력받아 CPOINT, CBUY, CGID update)	
	public int buy(int cid, int price) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String qur = "UPDATE CUSTOMER" + 
						" SET CPOINT=CPOINT+(?*0.05), CBUY=CBUY+?, " + 
						" CGID = (SELECT CS.CGID" + 
									" FROM CUSTOMER C, CUSGRADE CS" + 
									" WHERE CBUY+? BETWEEN LOPOINT AND HIPOINT AND CID=?)" + 
						" WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
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
	// 3. 물품 구입 후 구매자 정보 출력 : public CustomerDto getCustomer(int cid)	
	public CustomerDto getCustomer(int cid) {
		CustomerDto         dto = null;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String qur = "SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME," + 
				"       	(SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND" + 
				"    	FROM CUSTOMER C, CUSGRADE CU" + 
				"    	WHERE C.CGID=CU.CGID AND CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 검색 결과가 있을 경우 (cid가 있을 경우), dto에 CustomerDto 객체 생성하여 할당
				 //int cid = rs.getInt("cid");
				 String ctel = rs.getString("ctel");
				 String cname = rs.getString("cname");
				 int cpoint = rs.getInt("cpoint");
				 int cbuy = rs.getInt("cbuy");
				 String cgname = rs.getString("cgname");
				 int grnd = rs.getInt("grnd");
				 dto = new CustomerDto(cid, ctel, cname, cpoint, cbuy, cgname, grnd);
			}
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
		return dto;
	}
	// 4. 고객 등급 명 추출 
	public ArrayList<String> getLevelNames(){
		ArrayList<String> levelNames = new ArrayList<String>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet          rs   = null;
		String qur = "SELECT CGNAME FROM CUSGRADE";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				levelNames.add(rs.getString("cgName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return levelNames;
	}
	// 4. 등급별 고객 출력 : 
	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
			ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
			Connection         conn = null;
			PreparedStatement pstmt = null;
			ResultSet          rs   = null;
			String qur = "SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME," + 
					"       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND" + 
					"    	FROM CUSTOMER C, CUSGRADE CU" + 
					"   	WHERE C.CGID=CU.CGID AND CGNAME=UPPER(?)" + 
					"    	ORDER BY CBUY DESC";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(qur);
				pstmt.setString(1, levelName);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					 int cid       = rs.getInt("cid");
					 String ctel   = rs.getString("ctel");
					 String cname  = rs.getString("cname");
					 int cpoint    = rs.getInt("cpoint");
					 int cbuy      = rs.getInt("cbuy");
					 String cgname = rs.getString("cgname");
					 int grnd      = rs.getInt("grnd");
					 dtos.add(new CustomerDto(cid, ctel, cname, cpoint, cbuy, cgname, grnd));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn !=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return dtos;
	}
	// 5. 전체 출력 : 
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet          rs   = null;
		String qur = "SELECT CID, CTEL, CNAME, CPOINT, CBUY, CGNAME," + 
				"       (SELECT (HIPOINT+1)-CBUY FROM CUSTOMER WHERE CGID!=5 AND CID=C.CID) GRND" + 
				"    FROM CUSTOMER C, CUSGRADE CU" + 
				"    WHERE C.CGID=CU.CGID" + 
				"    ORDER BY CBUY DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 CustomerDto dto = new CustomerDto();
				 dto.setCid(rs.getInt("cid"));
				 dto.setCtel(rs.getString("ctel"));
				 dto.setCname(rs.getString("cname"));
				 dto.setCpoint(rs.getInt("cpoint"));
				 dto.setCbuy(rs.getInt("cbuy"));
				 dto.setCgname(rs.getString("cgname"));
				 dto.setGrnd(rs.getInt("grnd"));
				 dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 6. 회원 탈퇴 : 
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		String qur = "DELETE FROM CUSTOMER WHERE CTEL=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(qur);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
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
