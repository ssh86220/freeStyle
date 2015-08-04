package com.newlecture.web.vo;

import java.util.Date;
import java.util.List;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeFileDao;

public class Notice {

	private String code;
	private String content;
	private String writer;
	private String Title;
	private Date Regdate;
	private int hit;
	
	private String writerName;
	private int cmtCount;
	

	public List<NoticeFile> files;
	
	public List<NoticeFile> getFiles(){
		return files;
	}
	
/*	public List <NoticeFile> getFiles(){
		
		NoticeFileDao fileDao = new MybatisNoticeFileDao();
		
		return fileDao.getNoticeFilesOfNotice(this.code);
	}*/
	
	public void setFiles(List<NoticeFile> files) {
		this.files = files;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCnt(int cmtCount) {
		this.cmtCount= cmtCount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;	
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return Regdate;
	}
	public void setRegdate(Date regdate) {
		Regdate = regdate;
	}
	
	
	
}
