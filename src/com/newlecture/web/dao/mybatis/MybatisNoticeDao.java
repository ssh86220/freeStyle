package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;


public class MybatisNoticeDao implements NoticeDao{

	
	
	/*SqlSessionFactory factory =
			new SqlNewlecSessionFactory().getSqlSessionFactory();*/
	
	@Autowired
	private SqlSession session;

	
	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		NoticeFileDao fileDao = session.getMapper(NoticeFileDao.class);
		
		List<Notice> list= dao.getNotices(page, field, query);
		
		for(Notice n : list)
			n.setFiles(fileDao.getNoticeFilesOfNotice(n.getCode()));
		
		
		return dao.getNotices(1,"TITLE","");
		
	}

	@Override
	public Notice getNotice(String code) {
		
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
			
		return dao.getNotice(code);
	}

	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub
		return getNotices(1,"TITLE","");
	}

	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		return getNotices(page,"TITLE","");
	}

	@Override
	public int addNotice(Notice notice) {
		
		int result = 0;
		
		NoticeDao dao = session.getMapper(NoticeDao.class);
		result = dao.addNotice(notice);
		
		//SqlSession session = factory.openSession();//true AutoCommit
/*		try{
		NoticeDao dao = session.getMapper(NoticeDao.class);
		result = dao.addNotice(notice);
		session.commit();
		}
		finally{
			session.close();*/
		/*}*/
		return result;
	}

	@Override
	public String getLastCode() {
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
			
		return dao.getLastCode();
	}

}
