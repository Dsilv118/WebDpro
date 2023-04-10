package com.lec.ch12.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.service.Service;

public class BListService implements Service {

	@Override
	public void execute(Model model) {
		// ${pageNum }
		Map<String, Object> map = model.asMap(); // model을 map으로 변경
		// model.addAttribute("pageNum", null);
		String pageNum = (String) map.get("pageNum");
		if(pageNum == null) pageNum = "1";
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow    = (currentPage-1) * PAGESIZE + 1;
		int endRow      = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao();
		// 출력될 board list
		model.addAttribute("boardList", bDao.list(startRow, endRow));
		int orderNum = startRow; // 출력될 순차번호(1, 2, 3, ...)
		int totCnt = bDao.getBoardTotCnt(); // 전체 글 갯수
		int inverseNum = totCnt - startRow + 1; // 출력될 역순 번호(100, 99, 98, 97, ...)
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ( (currentPage-1) / BLOCKSIZE ) * BLOCKSIZE + 1; // jsp때 공식
		startPage = currentPage - (currentPage-1) % BLOCKSIZE; // 다른 공식
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		model.addAttribute("startPage", startPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pageNum", pageNum);
	}

}
