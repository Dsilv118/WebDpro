package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter을 받아서 DB에 저장
		int bid         = Integer.parseInt(request.getParameter("bid"));
		String bname    = request.getParameter("bname");
		String btitle   = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip      = request.getRemoteAddr();
		BoardDao bDao = new BoardDao();
		request.setAttribute("modifyResult", bDao.modify(bid, bname, btitle, bcontent, bip));
	}

}
