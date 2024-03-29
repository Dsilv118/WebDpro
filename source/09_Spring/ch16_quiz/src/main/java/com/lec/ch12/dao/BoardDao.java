package com.lec.ch12.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch12.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int totCnt();
	public int writeBoard(Board board);
	public int hitUp(int bid);
	public Board detailBoard(int bid);
	public int modifyBoard(Board board);
	public int deleteBoard(int bid);
	public int afterReply(Board board);
	public int writeReply(Board board);
}
