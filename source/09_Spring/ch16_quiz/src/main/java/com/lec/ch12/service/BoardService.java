package com.lec.ch12.service;

import java.util.List;

import com.lec.ch12.dto.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public int writeBoard(Board board);
	public int hitUp(int bid);
	public Board detailBoard(int bid);
	public int modifyBoard(Board board);
	public int deleteBoard(int bid);
	public int afterReply(Board board);
	public int writeReply(Board board);	
}
