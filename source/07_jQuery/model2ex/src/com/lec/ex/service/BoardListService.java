package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// list.jsp나 list.do?pageNum=2
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			if(request.getAttribute("pageNum")!=null) {
				pageNum = (String) request.getAttribute("pageNum");
			} else {
				pageNum = "1";
			}
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int startRow = (currentPage-1)*PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao();
		request.setAttribute("list", bDao.list(startRow, endRow)); // list.jsp에 출력될 글 목록
		int totCnt = bDao.getBoardTotCnt(); // 글 갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		// 페이지 관련 항복들
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
	}
}
