package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz5")
public class Quiz5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String detail = request.getParameter("detail");
        PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<link href=\"/ch04_servlet/css/Quiz5.css\" rel=\"stylesheet\"");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th colspan=\"2\">반갑습니다 " + writer + "님</th>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>글제목</th>");
		out.print("<td>"+title+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>글내용</th>");
		out.print("<td>"+detail+"</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
