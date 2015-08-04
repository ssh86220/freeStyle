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
// Annotation 코드에 남겨진 주석,코드수준의 설정(코드가 있어야함),쓰는이유:잘바꾸지 않는 설정이 많아서,편함
public class Add extends HttpServlet {

	// 두개를 합칠려면 service로 함수를 만들어서 사용한다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 가장먼저인코딩타입설정(언어)
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		// 입력?cnt=3
		// 번호는 문자열로온다. 그래서 int로 바꿔줘야함.
		// parsing 오류 500
		String _cnt = req.getParameter("cnt");

		PrintWriter out = resp.getWriter();

		int cnt = 10;

		if (_cnt != null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);

		/*
		 * for(int i=0;i<cnt;i++)
		 * 
		 * out.println("♥선희야 사랑해♡<br/>");
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
		// post만 쓰는거 따로 만들어주기

		
		if (req.getMethod().equals("POST")) {

			String _btn = req.getParameter("btn");
			if (_btn.equals("Application")) {

				ServletContext application = req.getServletContext();
				application.setAttribute("a", result);
				out.write("<p>Application에 저장완료</p>");

			} else if (_btn.equals("Session")) {
				
				 HttpSession session = req.getSession();
				 session.setAttribute("s", result);
				out.write("<p>Session에 저장완료</p>");
				
			} else if (_btn.equals("Cookie")) {
				
				Cookie cookie = new Cookie("c", String.valueOf(result));
				cookie.setMaxAge(24*60*60);
				resp.addCookie(cookie);
				
				out.write("<p>Cookie에 저장완료</p>");
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
		out.printf("<input type=\"submit\" name=\"btn\" value=\"덧셈\"/>&nbsp");
		out.printf("<input type=\"submit\" name=\"btn\" value=\"Application\"/>&nbsp");
		out.printf("<input type=\"submit\" name=\"btn\" value=\"Session\"/>&nbsp");
		out.printf("<input type=\"submit\"  name=\"btn\"value=\"Cookie\"/&nbsp>");
		out.printf("</p>");
		out.printf("</form>");
		out.printf("<p>덧셈 결과는 %d</p>", result);
		out.println("<a href=\"Mypage\">마이페이지</a>");

	}

	// get요청
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	// post요청 햄버거에 양파빼주세요.
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
