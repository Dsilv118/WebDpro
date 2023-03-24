package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.*;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean joinView = false;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) { // 첫 메인화면
			viewPage = "main/main.jsp";
		} else if(command.equals("/joinView.do")) {
			/*          Member 관련 요청                */
			viewPage = "member/join.jsp";
			joinView = true;
		} else if(command.equals("/midConfirm.do")) {
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
		} else if(command.equals("/memailConfirm.do")) {
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/emailConfirm.jsp";
		} else if(command.equals("/join.do")) {
			if(joinView) {
				service = new JoinService();
				service.execute(request, response);
				joinView = false;
			}
			viewPage = "loginView.do";
		} else if(command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		} else if(command.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/modifyView.do")) {
			viewPage = "member/modify.jsp";
		} else if(command.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/withdrawal.do")) {
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/adminLoginView.do")) { 
			/*          admin 관련 요청                */
			viewPage = "admin/adminLogin.jsp";
			joinView = true;
		} else if(command.equals("/adminLogin.do")) {
			if(joinView) {
				service = new ALoginService();
				service.execute(request, response);
				joinView = false;
			}
			viewPage = "/allView.do";
		} else if(command.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		} else if(command.equals("/boardList.do")) { 
			/*          파일첨부 게시판 관련 요청                */
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "fileBoard/boardList.jsp";
		} else if(command.equals("/boardWriteView.do")) {
			viewPage = "fileBoard/boardWrite.jsp";
			joinView = true;
		} else if(command.equals("/boardWrite.do")) {
			if(joinView) {
				service = new BoardWriteService();
				service.execute(request, response);
				joinView = false;
			}
			viewPage = "boardList.do";
		} else if(command.equals("/boardContent.do")) {
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "fileBoard/boardContent.jsp";
		} else if(command.equals("/boardModifyView.do")) {
			service = new BoardModifyViewService();
			service.execute(request, response);
			viewPage = "fileBoard/boardModify.jsp";
		} else if(command.equals("/boardModify.do")) {
			service = new BoardModifyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		} else if(command.equals("/boardDelete.do")) {
			service = new BoardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		} else if(command.equals("/boardReplyView.do")) {
			service = new BoardReplyViewService();
			service.execute(request, response);
			joinView = true;
			viewPage = "fileBoard/boardReply.jsp";
		} else if(command.equals("/boardReply.do")) {
			if(joinView) {
				service = new BoardReplyService();
				service.execute(request, response);
				joinView = false;
			}
			viewPage = "boardList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
 

