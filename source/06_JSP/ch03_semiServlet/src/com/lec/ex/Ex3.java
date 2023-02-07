package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<link href=\"/ch03_semiServlet/css/ex2.css\" rel=\"stylesheet\">");
		out.print("</head>");
		out.print("<body>");
		if(numStr==null) {
			response.getWriter().print("넘어온 파라미터가 없습니다");
		}else {
			int num = Integer.parseInt(numStr);
			out.print("<p>");
			out.print("<h2>" + num + "단" + "</h2>");
			out.print("</p>");
			for(int i=1 ; i<10 ; i++) {
				out.print("<p>");
				out.print(num + " * " + i + " = " + (num*i));
				out.print("</p>");
			}
		}
		out.print("</table>");
		out.print("</html>");
		out.close();
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
