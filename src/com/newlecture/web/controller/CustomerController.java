package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;

	
	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@RequestMapping("notice")
	public String notice(Model model) {
		/*NoticeDao noticeDao = new MybatisNoticeDao();*/
		List<Notice> list = noticeDao.getNotices();

		model.addAttribute("list", list);

		return "customer.notice";
		/*return "/WEB-INF/view/customer/notice.jsp";*/
	}

	// get,post요청 구분하지 않음.
	// set으로가져옴.
	@RequestMapping("noticeDetail")
	public String noticeDetail(String c, Model model) {
		/*NoticeDao noticeDao = new MybatisNoticeDao();*/
		Notice n = noticeDao.getNotice(c);

		model.addAttribute("n", n);

		return "customer.noticeDetail";
	}
	


	@RequestMapping(value = "noticeReg", method = RequestMethod.GET)
	public String noticeReg() {
		// get요청 - 포워드
		return "customer.noticeReg";

	}

	@RequestMapping(value = "noticeReg", method = RequestMethod.POST)
	public String noticeReg(Notice n, MultipartFile file, Principal principal, /*SecurityContextHolder holder,*/ SecurityContext context,
			HttpServletRequest request) throws IOException {
		// 포스트요청 - 리드렉트
		// set.parameter값 가져옴. notice에

		if(request.isUserInRole("ROLE_ADMIN"))
		{
			
		}
		
		//holder.getContext();
		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();
		
		n.setWriter(principal.getName());
		
		noticeDao.addNotice(n);
		String lastCode = noticeDao.getLastCode();
		
		if(!file.isEmpty()){
		ServletContext application = request.getServletContext();
		
		String url = "/resource/customer/upload";
		String path = application.getRealPath(url);
		String temp = file.getOriginalFilename();// part.getSubmittedFileName();
		String fname = temp.substring(temp.lastIndexOf("\\") + 1);
		String fpath = path + "\\" + fname;

		InputStream ins = file.getInputStream();// part.getInputStream();
		OutputStream outs = new FileOutputStream(fpath);

		byte[] 대야 = new byte[1024];
		int len = 0;

		while ((len = ins.read(대야, 0, 1024)) >= 0)
		outs.write(대야, 0, len);

		outs.flush();
		outs.close();
		ins.close();
		
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setName(fname);
		noticeFile.setNoticeCode(lastCode);
		noticeFileDao.addNoticeFile(noticeFile);
		}

		return "redirect:notice";

	}

}
