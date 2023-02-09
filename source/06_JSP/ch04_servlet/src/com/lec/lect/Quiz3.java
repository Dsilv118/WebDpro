package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz3")
public class Quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		PrintWriter out = response.getWriter();
		int i, a = 0;
		for(i=0; i<=num ; i++) {
			a += i;
		}
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("* {color: red};");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print("1부터 " + num + "까지의 누적 합은 " + a);
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
