package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Nana
 */
@WebServlet("/add")
// Annotation �ڵ忡 ������ �ּ�,�ڵ������ ����(�ڵ尡 �־����),��������:�߹ٲ��� �ʴ� ������ ���Ƽ�,����
public class Add extends HttpServlet {

	// �ΰ��� ��ĥ���� service�� �Լ��� ���� ����Ѵ�.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ����������ڵ�Ÿ�Լ���(���)
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		// �Է�?cnt=3
		// ��ȣ�� ���ڿ��ο´�. �׷��� int�� �ٲ������.
		// parsing ���� 500
		String _cnt = req.getParameter("cnt");

		PrintWriter out = resp.getWriter();

		int cnt = 10;

		if (_cnt != null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);

		/*
		 * for(int i=0;i<cnt;i++)
		 * 
		 * out.println("������� ����آ�<br/>");
		 */

		String _x = req.getParameter("x");
		String _y = req.getParameter("y");

		int x = 0;
		int y = 0;

		int result = 0;
		
		String _result = req.getParameter("result");
		if (_result != null && !_result.equals(""))
			result = Integer.parseInt(_result);
		
		
		/*
		 * ServletContext application = request.getServletContext(); HttpSession
		 * session = request.getSession();
		 */
		// post�� ���°� ���� ������ֱ�

		
		if (req.getMethod().equals("POST")) {

			String _btn = req.getParameter("btn");
			if (_btn.equals("Application")) {

				ServletContext application = req.getServletContext();
				application.setAttribute("a", result);
				out.write("<p>Application�� ����Ϸ�</p>");

			} else if (_btn.equals("Session")) {
				
				 HttpSession session = req.getSession();
				 session.setAttribute("s", result);
				out.write("<p>Session�� ����Ϸ�</p>");
				
			} else if (_btn.equals("Cookie")) {
				
				Cookie cookie = new Cookie("c", String.valueOf(result));
				cookie.setMaxAge(24*60*60);
				resp.addCookie(cookie);
				
				out.write("<p>Cookie�� ����Ϸ�</p>");
			} else {

				if (_x != null && !_x.equals(""))
					x = Integer.parseInt(_x);

				if (_y != null && !_y.equals(""))
					y = Integer.parseInt(_y);

				result = x + y;
			}
			
		}
		out.printf("<form action =\"add\" method=\"post\">");
		out.printf("<ul>");
		out.printf("<li><label for=\"x\">X :</label><input name =\"x\"/></li>");
		out.printf("<li><label for=\"y\">Y :</label><input name =\"y\"/></li>");
		out.printf("</ul>");
		out.printf("<p>");
		out.printf("<input type=\"hidden\"  name=\"result\"value=\"%d\"/&nbsp>", result);
		out.printf("<input type=\"submit\" name=\"btn\" value=\"����\"/>&nbsp");
		out.printf("<input type=\"submit\" name=\"btn\" value=\"Application\"/>&nbsp");
		out.printf("<input type=\"submit\" name=\"btn\" value=\"Session\"/>&nbsp");
		out.printf("<input type=\"submit\"  name=\"btn\"value=\"Cookie\"/&nbsp>");
		out.printf("</p>");
		out.printf("</form>");
		out.printf("<p>���� ����� %d</p>", result);
		out.println("<a href=\"Mypage\">����������</a>");

	}

	// get��û
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	// post��û �ܹ��ſ� ���Ļ��ּ���.
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
