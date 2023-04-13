package com.lec.ch12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.dto.Board;
import com.lec.ch12.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum, 5, 5);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int totCnt() {
		return boardDao.totCnt();
	}

	@Override
	public int writeBoard(Board board) {
		return boardDao.writeBoard(board);
	}

	@Override
	public int hitUp(int bid) {
		return boardDao.hitUp(bid);
	}

	@Override
	public Board detailBoard(int bid) {
		return boardDao.detailBoard(bid);
	}

	@Override
	public int modifyBoard(Board board) {
		return boardDao.modifyBoard(board);
	}

	@Override
	public int deleteBoard(int bid) {
		return boardDao.deleteBoard(bid);
	}

	@Override
	public int afterReply(Board board) {
		return boardDao.afterReply(board);
	}

	@Override
	public int writeReply(Board board) {
		return boardDao.writeReply(board);
	}

}
