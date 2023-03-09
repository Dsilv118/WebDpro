package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bname    = request.getParameter("bname");
		String btitle   = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		int bgroup  = Integer.parseInt(request.getParameter("bgroup"));  // 원글 정보
		int bstep   = Integer.parseInt(request.getParameter("bstep"));   // 원글 정보
		int bindent = Integer.parseInt(request.getParameter("bindent")); // 원글 정보
		String bip  = request.getRemoteAddr();
		BoardDao bDao = new BoardDao();
		request.setAttribute("replyResult", bDao.reply(bname, btitle, bcontent, bip, bgroup, bstep, bindent));
		/* 		// dto로 넣을시 아래 방법
		 * 		BoardDto bDto = new BoardDto(0, bname, btitle, bcontent, null, 0, bgroup, bstep, bindent, bip);				
		 * 		request.setAttribute("replyResult", bDao.reply(bDto));
		 */
	}

}
