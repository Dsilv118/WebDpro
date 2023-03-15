package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MidConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.idConfirm(mid);
		if(result == MemberDao.DUPLI) {
			request.setAttribute("midConfirmResult", "<b>중복된 ID입니다</b>");
		} else {
			request.setAttribute("midConfirmResult", "사용 가능한 ID입니다");
		}
	}

}
