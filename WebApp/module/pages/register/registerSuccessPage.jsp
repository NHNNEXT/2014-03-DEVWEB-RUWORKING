<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) request.getParameter("id");
	String email = (String) request.getParameter("email");
%>
<link rel="stylesheet" href="/css/page_style.css">
<div id="pageContainer">
<div id="ns-registerSuccess">	
	<div id="body-container">
	<div class="header">&nbsp;회원가입</div>
	<section>
		<span class="title">회원가입 성공</span>
		<div class = "noti">
		회원가입이 성공적으로 이루어 졌습니다.<br><br>
		비밀번호 암호화 작업등은 진행하였으나 학습 목적을 벗어나는 수준의 회원정보를 보호하는 활동은 진행하지 않습니다.<br><br>
		즐거운 사이트 이용 되세요
		</div>
	</section>
	<section>

		<span class="title">입력하신 정보</span>
		<div class="info-container">
		<div class="input-wrap">아이디 : <%= id %></div>
		<div class="input-wrap">비밀번호 : 암호화 되어 저장되었습니다</div>
		<div class="input-wrap">이메일 : <%= email %></div>
	
		<a href="/"><div id = "gohome" data-type="submit">홈으로 이동</div></a>
		</div>
	</section>
	</div>
</div>
</div>