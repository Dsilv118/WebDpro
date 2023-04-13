package com.lec.ch12.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch12.dto.Board;
import com.lec.ch12.service.BoardService;
import com.lec.ch12.util.Paging;

@Controller
@RequestMapping("mvcBoard")
public class MvcBoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="list", method={RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum, 5, 5));
		model.addAttribute("pageNum", pageNum);
		return "mvcBoard/list";
	}
	@RequestMapping(value="writeView", method={RequestMethod.GET, RequestMethod.POST})
	public String write() {
		return "mvcBoard/write";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeBoard(Board board, HttpServletRequest request, Model model) {
		try {
			board.setBip(request.getRemoteAddr());
			model.addAttribute("writeResult", boardService.writeBoard(board));
		} catch(Exception e) {
			model.addAttribute("writeResult", "글 쓰기 실패. 다시 확인해주세요.");
			System.out.println(e.getMessage());
			return "forward:wrtieView.do";
		}
		return "forward:list.do";
	}
	@RequestMapping(value="content")
	public String detailBoard(int bid, Model model) {
		model.addAttribute("bid", bid);
		boardService.hitUp(bid);
		model.addAttribute("contentBoard", boardService.detailBoard(bid));
		return "mvcBoard/content";
	}
	@RequestMapping(value="modifyView", method={RequestMethod.GET, RequestMethod.POST})
	public String modify(int bid, Model model) {
		model.addAttribute("bid", bid);
		model.addAttribute("board", boardService.detailBoard(bid));
		return "mvcBoard/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("modifyResult", boardService.modifyBoard(board));
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		int result = boardService.deleteBoard(bid);
		if(result == 1) {
			model.addAttribute("deleteResult", bid + "번 글 삭제 성공");
		} else if(result == 0) {
			model.addAttribute("deleteResult", bid + "번 글 삭제 실패");
		}
		return "forward:list.do";
	}
	@RequestMapping(value="replyView", method={RequestMethod.GET, RequestMethod.POST})
	public String reply(int bid, String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("bid", bid);
		model.addAttribute("board", boardService.detailBoard(bid));
		return "mvcBoard/reply";
	}
	@RequestMapping(value="reply", method={RequestMethod.GET, RequestMethod.POST})
	public String reply(Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		boardService.afterReply(board);
		model.addAttribute("replyResult", boardService.writeReply(board));
		return "forward:list.do";
	}
}














