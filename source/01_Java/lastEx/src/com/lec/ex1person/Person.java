package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sca = new Scanner(System.in);
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet          rs   = null;
		String qur;
		ArrayList<String> jobs = new ArrayList<>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(exm);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
