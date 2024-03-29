package com.lec.lect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(urlPatterns = {"/Ex4_initParam"}, 
			initParams = {@WebInitParam(name="id", value="root"),
						  @WebInitParam(name="pw", value="mysql"),
						  @WebInitParam(name="jdbcdriver", value="com.mysql.jdbcDriver")}			
			)*/
public class Ex4_initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 초기화 파라미터를 웹 브라우저와 콘솔에 출력
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String driver = getInitParameter("jdbcdriver");
		response.setContentType("text/html");
		response.getWriter().println("id = " + id + "<br>");
		response.getWriter().println("pw = " + pw + "<br>");
		response.getWriter().println("driver = " + driver);
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);
		System.out.println("driver = " + driver);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
