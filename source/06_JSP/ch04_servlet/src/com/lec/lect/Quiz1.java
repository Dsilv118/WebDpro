package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] num = request.getParameterValues("gugudan");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		for(int i=0 ; i<num.length ; i++) {
			out.print("<th>");
			out.print(Integer.parseInt(num[i]) +"단");
			out.print("</th>");
		}
		out.print("</tr>");
		for(int i=1 ; i<10 ; i++) {
			out.print("<tr>");
			for(int x=0 ; x<num.length ; x++) {
				out.print("<td>");
				out.print(Integer.parseInt(num[x]) + " x " + i + " = " + (Integer.parseInt(num[x])*i));
				out.print("</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
