<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:scriptlet>
pageContext.setAttribute("space", " ");
pageContext.setAttribute("lf", "\n");
</jsp:scriptlet>
<div id="pageContainer">
	<div id="ns-evidenceDetail">
		<div class="evidence-wrapper">
			<div class="article-header">
				<div class="title">${article.title}</div>
				<div class="date">${article.date}</div>
				<div class="basic-info">
					글쓴이
					<div class="userId">${article.userId}</div>
					조회
					<div>0</div>
					댓글
					<div>0</div>
				</div>
			</div>
			<div class="line"></div>
			<div class="content">${fn:replace( fn:replace(article.content, space, "&nbsp;"), lf, "<br/>")}</div>
		</div>
		<a class="show-list">목록보기</a>
		<form class="comment-input">
			<input class="comment-box" type="text"> <input
				class="comment-submit" type="submit" value="댓글 등록">
		</form>
		<ul class="comment-list">
			<li class="show-comment"><span class="user-id">아이디</span> <span
				class="comment">안녕하십니다. 참 재미있네요</span> <span class="date">${article.date}</span>
			</li>
			<div class="line"></div>
			<li class="show-comment"><span class="user-id">아이디</span> <span
				class="comment">안녕하십니다. 참 재미있네요</span> <span class="date">${article.date}</span>
			</li>
			<div class="line"></div>
		</ul>
	</div>
</div>
