package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		int color = Integer.parseInt(request.getParameter("color"));
		String[] bcolors = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		String[] fcolors = {"violet", "red", "orange", "yellow", "green", "blue", "navy"};
		PrintWriter out = response.getWriter();
		String bcolor = bcolors[color];
		String fcolor = fcolors[color];
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("* {color: " + fcolor + "; background-color: " + bcolor + "};");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print("GET방식 요청입니다<br>");
		out.print("글자색은 " + fcolor + ", 배경색은 " + bcolor + "입니다");
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int color = Integer.parseInt(request.getParameter("color"));
		String[] bcolors = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		String[] fcolors = {"violet", "red", "orange", "yellow", "green", "blue", "navy"};
		PrintWriter out = response.getWriter();
		String bcolor = bcolors[color];
		String fcolor = fcolors[color];
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("* {color: " + fcolor + "; background-color: " + bcolor + "};");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print("POST방식 요청입니다<br>");
		out.print("글자색은 " + fcolor + ", 배경색은 " + bcolor + "입니다");
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
