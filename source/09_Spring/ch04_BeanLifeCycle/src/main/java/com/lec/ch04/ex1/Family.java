package com.lec.ch04.ex1;

import lombok.Data;

@Data
public class Family {
	private String papaName;
	private String mamaName;
	private String brotherName;
	private String sisterName;
	
	public Family(String papaName, String mamaName) {
		this.papaName = papaName;
		this.mamaName = mamaName;
	}
}
