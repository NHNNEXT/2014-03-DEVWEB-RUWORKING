<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일해요? 일해요!</title>
<link rel="stylesheet" href="/module/layout/css/common_style.css">
<link rel="stylesheet" href="/css/page_style.css">
<link rel="stylesheet" href="/library/css/Nwagon.css">
<script src="/module/layout/js/common_template.js"></script>
<script src="/library/js/Nwagon.js"></script>
</head>
<body>
<!-- body 전체 container -->
<div id = "body-container">
	<!-- header -->
	<header>
        <a href="/" tabindex="-1"><div class = "logo">일해요</div></a>
        <div class = "upload">업로드</div>
        <div class="searchBox">
        	<form action="search.ruw" autocomplete="off" name="searchForm">
        		<input type="text" class = "inputbox" name="userQuery" placeholder="정당 / 정치인 이름 입력">
        		<input type="submit" class = "submit_btn" value="검색" tabindex="-1">
        	</form>
        	<div class="label">엔터 (Enter)</div>
        	<div class="search-result">
        		<div class="main"></div>
        		<div class="footer">스마트 Quick Search <sup>beta</sup></div>
        	</div>
        </div>
	</header>
	<!-- // header -->
	
	<!-- navigation bar on left side -->
	<nav>
		<c:choose>
		<c:when test="${empty sessionScope.userId}">
	    	<a href="/Register.ruw" tabindex="-1"><span class = "signin">회원가입</span></a>
	    	<span class = "login_out">로그인</span>
	    </c:when>
	    <c:otherwise>
	   		<span class = "userId">${sessionScope.userId}</span>
	    	<a href="/Logout.ruw" tabindex="-1"><span class = "login_out">로그아웃</span></a>
	    </c:otherwise>
	    </c:choose>
	    <div class="login-wrap">
	    	<div class="login-pop on">로그인</div>
	    	<div class="login-form">
	    		<form method ="POST" action="Login.ruw">
	   				<input type="text" name="userId" placeholder="아이디">
	   				<input type="password" name="userPw" placeholder="비밀번호">
	   				<input type="submit" class="submit" value="로그인  ">
	   				<div class="cancel">로그인 취소</div>
    			</form>
	    	</div>
	    </div>
	    <div class = "list-wrap">
	    	<a href="/"><span class = "list on">메인</span></a>
			<span class = "list">우리지역</span>
			<a href="/Parties.ruw"><span class="list">정당별</span></a>
			<span class = "list">정치인</span>
		</div>
		<div class="floatIntroduce">
			<span>일해요 서비스 소개</span>
		</div>
		<div class="logoBottom">
			<span>일해요</span>
		</div>
	</nav>
	<!-- // navigation bar on left side -->

	<!-- main -->
	<div id = "main">
		<div class="searchinfo">
			<div class="mask"></div>
			<div class="info"></div>
			<div class="bg"></div>
		</div>
		<div class="updated">이 페이지는 2014-03-02 17:32 기준 일해요의 <u>편집기준</u>에 의거하여 작성되었습니다</div>
		<!-- end of top.html -->