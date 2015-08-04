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


@WebServlet("/Mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//���� ��ü�� ����  application
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		int a = 0;
		int s = 0;
		int c = 0;
		
		
		Cookie[] cookies = request.getCookies();
		String _c=null;
		
		if(cookies != null)
			for(Cookie cookie : cookies)
				if("c".equals(cookie.getName()))
					_c = cookie.getValue();
			
		Object _a = application.getAttribute("a");
		Object _s = session.getAttribute("s");
		
		if(_a != null)
			//a=Integer.parseInt((String) _a);
			a=(int)_a;
		if(_s != null)
			//s=Integer.parseInt((String) _s);
			s=(int)_s;
		if(_c != null)
			c=Integer.parseInt((String) _c);
		
		
		out.printf("<p>Application : %d</p>", a);
		out.printf("<p>Session : %d</p>", s);
		out.printf("<p>Cookie : %d</p>", c);
		out.println("<p><a href=\"add\">���ư���</a></p>");
	
		//app
		
	}
}
