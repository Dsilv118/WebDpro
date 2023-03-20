package com.lec.skyticket.dao;

import java.sql.Date;

public class BoardDao {
	private String bid;
	private String mid;
	private String bsubject;
	private String bcontent;
	private String bfile;
	private String bip;
	private int bgroup;
	private int bstep;
	private int bindent;
	private Date brdate;
	public BoardDao() {}
	public BoardDao(String bid, String mid, String bsubject, String bcontent, String bfile, String bip, int bgroup,
			int bstep, int bindent, Date brdate) {
		this.bid = bid;
		this.mid = mid;
		this.bsubject = bsubject;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bip = bip;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.brdate = brdate;
	}
	@Override
	public String toString() {
		return "BoardDao [bid=" + bid + ", mid=" + mid + ", bsubject=" + bsubject + ", bcontent=" + bcontent
				+ ", bfile=" + bfile + ", bip=" + bip + ", bgroup=" + bgroup + ", bstep=" + bstep + ", bindent="
				+ bindent + ", brdate=" + brdate + "]";
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBsubject() {
		return bsubject;
	}
	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	public Date getBrdate() {
		return brdate;
	}
	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}
	
}
