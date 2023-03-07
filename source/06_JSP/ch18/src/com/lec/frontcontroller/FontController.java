package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.*;

@WebServlet("*.do")
public class FontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 무슨 요청이 들어왔는지 판별(select.do, insert.do, update,do, delete,do)
		// URL     : http://localhost:8090/ch18/insert.do
		String uri = request.getRequestURI();	          // URI     : /ch18/select.do
		String conPath = request.getContextPath();        // conPath : /ch18
		String commend = uri.substring(conPath.length()); // command : /~~.do
		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("들어온 요청 : " + commend);
		// 들어온 요청에 따라 다른 일을 하고 뷰로 forward
		String viewPage = null; // 뷰 페이지를 저장할 변수
		Service service = null; // InsertService나 SelectService나 DeleteService, UpdateService
		if(commend.equals("/insert.do")) {
			service = new InsertService();
			service.execute(request, response);
			viewPage = "select.do";
		} else if (commend.equals("/select.do")) {
			service = new SelectService();
			service.execute(request, response);
			viewPage = "ex2/select.jsp";
		} else if (commend.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response);
			viewPage = "select.do";
		} else if (commend.equals("/delete.do")) {
			service = new DeleteService();
			service.execute(request, response);
			viewPage = "select.do";
		}
		// viewPage로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
