package com.lec.ch12.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BoardDto {
	private int       bid;
	private String    bname;
	private String    btitle;
	private String    bcontent;
	private Timestamp bdate;
	private int       bhit;
	private int       bgroup;
	private int       bstep;
	private int       bindent;
	private String    bip;
	private int    	  startRow; // 페이징 처리를 위한 속성 변수
	private int       endRow;   // 페이징 처리를 위한 속성 변수
}
