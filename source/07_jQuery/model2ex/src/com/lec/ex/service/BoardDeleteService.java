package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = new BoardDao();
		int result  = bDao.deleteBoard(fid);
		String deleteResult = result == 1 ? "글 삭제 성공" : "글 삭제 실패";
		request.setAttribute("deleteResult", deleteResult);
	}
}
