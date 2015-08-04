package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/hi")
//Annotation 코드에 남겨진 주석,코드수준의 설정(코드가 있어야함),쓰는이유:잘바꾸지 않는 설정이 많아서,편함
public class Nana extends HttpServlet {
	   
	//get요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//가장먼저인코딩타입설정(언어)
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//입력?cnt=3 
		//번호는 문자열로온다. 그래서 int로 바꿔줘야함. 
		//parsing 오류 500
		PrintWriter out = response.getWriter();
		
		String _cnt = request.getParameter("cnt");
		
		int cnt = 10;
		
		if(_cnt != null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);
		
		for(int i=0;i<cnt;i++){
		out.println("♥Sunny Love♡<br/>");
		out.println("♥선희야 사랑해♡<br/>");
		}	
	}
	//post요청 햄버거에 양파빼주세요. 
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String _x = req.getParameter("x");
			String _y = req.getParameter("y");
			
			int x=0;
			int y=0;
			
			int result =0;
			
			if(_x != null && !_x.equals("") )
				x = Integer.parseInt(_x);
			
			if(_y != null && !_y.equals("") )
				y= Integer.parseInt(_y);
			
			result = x+y;
			
			PrintWriter out = resp.getWriter();		
			
			out.printf("<form action =\"hi\" method=\"post\">");
			out.printf("<ul>");
			out.printf("<li><label for=\"x\">X :</label><input name =\"x\"/></li>");
			out.printf("<li><label for=\"y\">Y :</label><input name =\"y\"/></li>");
			out.printf("</ul>");
			out.printf("<p><input type=\"submit\" value=\"덧셈\"/>&nbsp");
			out.printf("<input type=\"submit\" value=\"Application\"/>&nbsp");
			out.printf("<input type=\"submit\" value=\"Session\"/>&nbsp");
			out.printf("<input type=\"submit\" value=\"Cookie\"/&nbsp></p>");
			out.printf("</form>");
			out.printf("<p>덧셈 결과는 %d</p>",result);
			out.println("<a href=\"Mypage\">마이페이지</a>");
			
					
	}
	
	
}
