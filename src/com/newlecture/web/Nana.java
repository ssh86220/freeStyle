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
//Annotation �ڵ忡 ������ �ּ�,�ڵ������ ����(�ڵ尡 �־����),��������:�߹ٲ��� �ʴ� ������ ���Ƽ�,����
public class Nana extends HttpServlet {
	   
	//get��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//����������ڵ�Ÿ�Լ���(���)
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//�Է�?cnt=3 
		//��ȣ�� ���ڿ��ο´�. �׷��� int�� �ٲ������. 
		//parsing ���� 500
		PrintWriter out = response.getWriter();
		
		String _cnt = request.getParameter("cnt");
		
		int cnt = 10;
		
		if(_cnt != null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);
		
		for(int i=0;i<cnt;i++){
		out.println("��Sunny Love��<br/>");
		out.println("������� ����آ�<br/>");
		}	
	}
	//post��û �ܹ��ſ� ���Ļ��ּ���. 
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
			out.printf("<p><input type=\"submit\" value=\"����\"/>&nbsp");
			out.printf("<input type=\"submit\" value=\"Application\"/>&nbsp");
			out.printf("<input type=\"submit\" value=\"Session\"/>&nbsp");
			out.printf("<input type=\"submit\" value=\"Cookie\"/&nbsp></p>");
			out.printf("</form>");
			out.printf("<p>���� ����� %d</p>",result);
			out.println("<a href=\"Mypage\">����������</a>");
			
					
	}
	
	
}
