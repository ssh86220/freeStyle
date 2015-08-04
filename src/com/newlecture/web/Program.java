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
		// Dependency New,injection  여기서 만들게 되면 귀찮음. 이걸 수정할 필요없게 만드는녀석이 필요함. 
		/*NoticeConsole console = ctx.getBean(""); //객체생성조립과정(생성조립를 바꾸기위해서)을 컨테이너가 다해줌. 
		console.print();*/
		

		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/spring_context.xml");
		NoticeConsole console = (NoticeConsole) context.getBean("console");	
		console.print();
	}

}
