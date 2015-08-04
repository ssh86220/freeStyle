﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri= "http://tiles.apache.org/tags-tiles"%>

<c:set var="ctName" value='${pageContext.request.contextPath}' />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%
	/* NoticeDao noticeDao = new MybatisNoticeDao();
	List<Notice> list = noticeDao.getNotices();

	request.setAttribute("list", list); */
%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<link href="../resource/customer/notice.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- 헤더영역 -->
	<tiles:insertAttribute name="header" />
<%-- 	<jsp:include page="../inc/header.jsp" /> --%>
	<div id="visual" class="customer">
		<div class="top-wrapper"></div>
	</div>
	<div id="main">
		<div class="top-wrapper clear">
			<!-- 바디부분 -->
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<!-- 푸터부분 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>
