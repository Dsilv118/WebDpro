package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.AdminDao;
import com.lec.ex.dao.MemberDao;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = AdminDao.getInstance();
		int result = aDao.loginChk(aid, apw);
		if(result==aDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", aDao.getAdmin(aid));
			request.setAttribute("loginSuccessMsg", "관리자 모드로 로그인하셨습니다");
		} else {
			request.setAttribute("loginErrorMsg", "관리자 모드입니다. 일반회원은 일반 로그인을 이용해주세요");
		}
	}
}
