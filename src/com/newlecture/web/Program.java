package com.newlecture.web;

import javax.servlet.ServletException;

import net.sf.cglib.proxy.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.View;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;


public class Program {

	static{
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static void main(String[] args){
		
		//Dependency New
/*		NoticeDao noticeDao = new MybatisNoticeDao();
		
		NoticeConsole console = new NoticeConsole();
		console.setNoticeDao(noticeDao); //injection 
*/		
		// Dependency New,injection  ���⼭ ����� �Ǹ� ������. �̰� ������ �ʿ���� ����³༮�� �ʿ���. 
		/*NoticeConsole console = ctx.getBean(""); //��ü������������(���������� �ٲٱ����ؼ�)�� �����̳ʰ� ������. 
		console.print();*/
		

		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/spring_context.xml");
		NoticeConsole console = (NoticeConsole) context.getBean("console");	
		console.print();
	}

}
