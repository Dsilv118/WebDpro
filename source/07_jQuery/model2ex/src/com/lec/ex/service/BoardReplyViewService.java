package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid")); // 원글의 글번호
		BoardDao bDao = new BoardDao();
		request.setAttribute("BoardReply", bDao.content(fid)); // 원글 dto
	}

}
