package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;


public class newlecAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	
	private MemberDao memberdao;
	
	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {	
		
		String uid = authentication.getName();
		
		Member m =memberdao.getMember(uid);
		
		String type =m.getDefaultRole();
		
		String targetUrl = "/customer/notice";
		
		if(type.equals("ROLE_TEACHER"))
			targetUrl ="/customer/noticeDetail?c=7";
		
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
}
